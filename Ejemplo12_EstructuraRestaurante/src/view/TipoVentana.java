package view;

public class TipoVentana {
    public enum Ventana {
        LOGIN(1),
        VENTANA_REGISTRO(2),
        INICIO_ADMIN(3),
        INICIO_CLIENTE(4);
        
        private final int index;

        Ventana(int index) {
            this.index = index;
        }

        public int getIndex() {
            return index;
        }
    }
}