package com.canchapro.modelo;
import java.util.ArrayList;
import java.io.*;
public class RegistroDePagos {
    private ArrayList<Pago> pagos=new ArrayList<>();
    public double pagado(String codigo){double n=0;for(Pago p:pagos)if(p.getReserva().equals(codigo))n+=p.getMonto();return n;}
    public boolean agregar(Reservacion r,double monto,String metodo,String observacion){
        if(r==null||(!Double.isFinite(monto))||monto<=0||metodo==null||metodo.trim().isEmpty()||r.getEstado().equals("CANCELADA")||monto>r.CalcularTotal()-pagado(r.getCodigo())+0.0001)return false;
        pagos.add(new Pago("P"+System.nanoTime(),r.getCodigo(),monto,metodo,observacion));guardar();return true;
    }
    public ArrayList<Pago> getPagos(){return pagos;}
    public void guardar(){try(PrintWriter w=new PrintWriter(new FileWriter("pagos.csv"))){for(Pago p:pagos)w.println(p.getCodigo()+";"+p.getReserva()+";"+p.getMonto()+";"+p.getMetodo()+";"+p.getObservacion().replace(";"," ")+";"+p.getFecha());}catch(IOException e){System.out.println("Error guardando pagos: "+e.getMessage());}}
    public void cargar(){File f=new File("pagos.csv");if(!f.exists())return;pagos.clear();try(BufferedReader b=new BufferedReader(new FileReader(f))){String l;while((l=b.readLine())!=null){try{String[] d=l.split(";",-1);if(d.length!=6)throw new Exception();double monto=Double.parseDouble(d[2]);if(!Double.isFinite(monto)||monto<=0)throw new IllegalArgumentException();pagos.add(new Pago(d[0],d[1],monto,d[3],d[4],d[5]));}catch(Exception ex){System.out.println("Pago incorrecto, se omite");}}}catch(IOException e){System.out.println("Error leyendo pagos");}}
}
