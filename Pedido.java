

/**
 * Modela un pedido realizado por un cliente en una determinada fecha
 * El pedido incluye dos líneas de pedido que describen a cada uno de los dos
 * productos comprados en el pedido
 * @author David Ganuza
 */
public class Pedido
{
    private final double IVA = 0.21;  // iva a aplicar
    private Fecha fecha;
    private Cliente cliente;
    private LineaPedido linea1;
    private LineaPedido linea2;

    /**
     * Constructor  
     */
    public Pedido()    {
         this.fecha = new Fecha(fecha.getDia(), fecha.getMes(), fecha.getYear());
         this.cliente = new Cliente(cliente.getNombre(), cliente.getDireccion(),
         cliente.getCiudad(), cliente.getProvincia());
         this.linea1 = new LineaPedido(linea1.getProducto(), linea1.getCantidad());
         this.linea2 = new LineaPedido(linea2.getProducto(), linea2.getCantidad());
    }

    /**
     * accesor para la fecha del pedido
     */
    public Fecha getFecha() {
         return fecha;
    }

    /**
     * accesor para el cliente
     */
    public Cliente getCliente() {
         return cliente;
    }
    
    
    /**
     * calcular y devolver el importe total del pedido sin Iva
     */
    public double getImporteAntesIva() {
         double aux = (linea1.getCantidad() * linea1.getProducto().getPrecio()) +
         (linea2.getProducto().getPrecio() * linea2.getCantidad());
         return aux;
    }

    /**
     * calcular y devolver el iva a aplicar
     */
    public double getIva() {
         double iva = getImporteAntesIva() * IVA;
         return iva;
    }

    /**
     * calcular y devolver el importe total del pedido con Iva
     */
    public double getImporteTotal() {
         double total = getImporteAntesIva() + getIva();
         return total;
    }

    /**
     * Representación textual del pedido
     * (ver enunciado)
     */
    public String toString() {
        return ("FECHA PEDIDO: " + fecha 
        + "\nDATOS DEL CLIENTE"
        + "\n" + cliente.toString() 
        + "\n**** Articulos en el pedido ****"
        + "\n" + linea1.toString()
        + "\n" + linea2.toString()
        + "\n**** A pagar ****"
        + "\nIMPORTE SIN IVA: " + getImporteAntesIva()
        + "\n            IVA: " + getIva()
        + "\n  IMPORTE TOTAL: " + getImporteTotal());
    }
    
    
    /**
     * devuelve true si el pedido actual es más antiguo que el recibido 
     * como parámetro
     */
    public boolean masAntiguoQue(Pedido otro) {
        boolean aux = false; 
        if (this.fecha.getYear() < otro.fecha.getYear()){
             if (this.fecha.getMes() < otro.fecha.getMes()){
                if (this.fecha.getDia() < otro.fecha.getDia()){
                aux = true;
                }
             }
            }
            return aux;
    }
    
     /**
     * devuelve una referencia al pedido actual
     */
    public Pedido getPedidoActual() {
        return (this.fecha + this.cliente + this.linea1 + this.linea2);
    }

}
