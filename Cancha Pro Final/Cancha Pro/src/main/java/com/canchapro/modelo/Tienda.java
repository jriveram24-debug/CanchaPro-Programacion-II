
package com.canchapro.modelo;


public class Tienda {
    private String nombre;
    private boolean activa;
    
    private Productos[] productos;
    private int cantidadProductos;
    
    public Tienda(String nombre){
    this.nombre = nombre;
    this.activa = false;
    this.productos = new Productos[20];
    this.cantidadProductos = 0;
    
    }
    
    public void activarTienda(){
    activa  = true;
        System.out.println("MODULO DE TIENDA ACTIVADO CORRECTAMENTE");
    }
    
    public void cancelarTienda(){
    activa = false;
        System.out.println("EL MODULO DE TIENDA ESTA DESACTIVADA");
    }
    public boolean isACtiva(){
    return activa;
    }
    
    
    
    public boolean agregarProducto(Productos nuevo){
        
        
        if (buscarProducto(nuevo.getCodigo()) != null) {
            System.out.println("Ya existe un producto con ese codigo");
            return false;
}
        
        if (cantidadProductos >= productos.length){
            System.out.println("La tienda esta llena");
            return false;
        }
        
        productos[cantidadProductos] = nuevo;
        cantidadProductos++;
        
        System.out.println("Producto Agregado");
        guardarProductos();
        return true;
}
    public Productos buscarProducto(String codigo) {
        for (int i = 0; i < cantidadProductos; i++) {
            if (productos[i].getCodigo().equalsIgnoreCase(codigo)) {
            return productos[i];
        }
    }

    return null;
}
    
    
    public boolean realizarVenta(String codigo,int cantidad){return realizarVenta(codigo,cantidad,null);}

    private java.util.ArrayList<String> ventas = new java.util.ArrayList<>();
    public int getCantidadProductos(){return cantidadProductos;}
    public Productos getProducto(int i){return i>=0&&i<cantidadProductos?productos[i]:null;}
    public boolean realizarVenta(String codigo,int cantidad,String reserva){
        java.util.LinkedHashMap<String,Integer> lista=new java.util.LinkedHashMap<>();lista.put(codigo,cantidad);
        return realizarVentaMultiple(lista,reserva,"EFECTIVO");
    }
    public boolean realizarVentaMultiple(java.util.Map<String,Integer> lista,String reserva,String metodo){
        if(!activa){System.out.println("La tienda está desactivada");return false;}
        if(lista==null||lista.isEmpty()||metodo==null||metodo.trim().isEmpty()){System.out.println("Datos de venta incompletos");return false;}
        for(java.util.Map.Entry<String,Integer> e:lista.entrySet()){
            Productos p=buscarProducto(e.getKey());
            if(p==null){System.out.println("Producto no encontrado: "+e.getKey());return false;}
            if(e.getValue()==null||e.getValue()<=0){System.out.println("Cantidad inválida");return false;}
            if(!p.isActivo()){System.out.println("Producto inactivo: "+p.getNombre());return false;}
            if(p.getStock()<e.getValue()){System.out.println("Stock insuficiente para "+p.getNombre());return false;}
        }
        String id="V"+System.nanoTime();String fecha=java.time.LocalDateTime.now().toString();
        for(java.util.Map.Entry<String,Integer> e:lista.entrySet()){
            Productos p=buscarProducto(e.getKey());p.venderProduct(e.getValue());
            ventas.add(id+";"+fecha+";"+(reserva==null?"DIRECTA":reserva)+";"+p.getCodigo()+";"+e.getValue()+";"+p.getPrecio()+";"+metodo+";"+(reserva==null?"PAGADA":"PENDIENTE"));
        }
        guardarProductos();guardarVentas();return true;
    }
    public double totalPendiente(String reserva){
        double total=0;
        for(String v:ventas){String[] d=v.split(";",-1);if(d.length==8&&d[2].equals(reserva)&&d[7].equals("PENDIENTE"))try{total+=Integer.parseInt(d[4])*Double.parseDouble(d[5]);}catch(Exception e){} }
        return total;
    }
    public void liquidarPendiente(String reserva){
        for(int i=0;i<ventas.size();i++){
            String[] d=ventas.get(i).split(";",-1);
            if(d.length==8&&d[2].equals(reserva)&&d[7].equals("PENDIENTE")){d[7]="PAGADA";ventas.set(i,String.join(";",d));}
        }guardarVentas();
    }
    public String reporteVentas(String periodo){
        double total=0;int unidades=0;java.util.Map<String,Double> categorias=new java.util.LinkedHashMap<>();
        for(String v:ventas){String[] d=v.split(";",-1);if(d.length!=8||!d[1].startsWith(periodo))continue;
            try{int n=Integer.parseInt(d[4]);double subtotal=n*Double.parseDouble(d[5]);unidades+=n;total+=subtotal;
                Productos p=buscarProducto(d[3]);String categoria=p==null?"Sin categoría":p.getCategoria();categorias.merge(categoria,subtotal,Double::sum);
            }catch(Exception e){}
        }
        return "Unidades vendidas: "+unidades+"\nVentas Q"+String.format("%.2f",total)+"\nIngresos por categoría: "+categorias+"\n";
    }
    public void guardarProductos(){
        try(java.io.PrintWriter w=new java.io.PrintWriter(new java.io.FileWriter("productos.txt"))){
            w.println(activa);
            for(int i=0;i<cantidadProductos;i++){
                Productos p=productos[i];w.println(p.getCodigo()+";"+p.getNombre()+";"+p.getPrecio()+";"+p.getStock()+";"+p.getCategoria()+";"+p.getStockmin()+";"+p.isActivo());
            }
        }catch(Exception e){System.out.println("Error guardando productos: "+e.getMessage());}
    }
    public void cargarProductos(){
        java.io.File f=new java.io.File("productos.txt");if(!f.exists())return;
        try(java.util.Scanner sc=new java.util.Scanner(f)){
            if(sc.hasNextLine())activa=Boolean.parseBoolean(sc.nextLine());
            cantidadProductos=0;
            while(sc.hasNextLine()&&cantidadProductos<productos.length){
                String[] d=sc.nextLine().split(";",-1);if(d.length!=6&&d.length!=7)continue;
                try{Productos producto=new Productos(d[1],d[0],Double.parseDouble(d[2]),Integer.parseInt(d[3]),d[4],Integer.parseInt(d[5]));if(d.length==7)producto.setActivo(Boolean.parseBoolean(d[6]));
                    if(producto.getCodigo().trim().isEmpty()||producto.getNombre().trim().isEmpty()||producto.getPrecio()<=0||producto.getStock()<0||producto.getStockmin()<0||buscarProducto(producto.getCodigo())!=null)throw new IllegalArgumentException("Producto incorrecto");
                    productos[cantidadProductos++]=producto;}catch(Exception ex){System.out.println("Producto inválido");}
            }
        }catch(Exception e){System.out.println("Error cargando productos: "+e.getMessage());}
    }
    public void guardarVentas(){
        try(java.io.PrintWriter w=new java.io.PrintWriter(new java.io.FileWriter("ventas.txt"))){for(String v:ventas)w.println(v);}
        catch(Exception e){System.out.println("Error guardando ventas: "+e.getMessage());}
    }
    public void cargarVentas(){
        java.io.File f=new java.io.File("ventas.txt");if(!f.exists())return;
        ventas.clear();try(java.util.Scanner sc=new java.util.Scanner(f)){while(sc.hasNextLine()){
            String linea=sc.nextLine();String[] d=linea.split(";",-1);
            if(d.length==8){
                try{if(Integer.parseInt(d[4])<=0||Double.parseDouble(d[5])<0)throw new IllegalArgumentException();ventas.add(linea);}
                catch(Exception ex){System.out.println("Venta inválida, se omite");}
            }else if(d.length==4){
                ventas.add("V_ANTIGUA_"+ventas.size()+";2000-01-01T00:00;"+d[0]+";"+d[1]+";"+d[2]+";"+d[3]+";EFECTIVO;"+(d[0].equals("DIRECTA")?"PAGADA":"PENDIENTE"));
            }else System.out.println("Venta inválida, se omite");
        }}
        catch(Exception e){System.out.println("Error cargando ventas: "+e.getMessage());}
    }
} 
