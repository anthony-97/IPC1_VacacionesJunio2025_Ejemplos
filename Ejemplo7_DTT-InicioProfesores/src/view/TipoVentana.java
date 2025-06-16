package view;

public class TipoVentana {
    public enum Ventana {
        LOGIN(1),
        INICIO_ADMIN(2),
        INICIO_PROFESOR(3),
        INICIO_ALUMNOS(4);

        private final int index;

        Ventana(int index) {
            this.index = index;
        }

        public int getIndex() {
            return index;
        }
    }
}