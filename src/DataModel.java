public class DataModel {
    String temporada,temperatura,oxigenacion;
    boolean dificultad_respirar,contagiado;

    public  DataModel(){}



    public DataModel(String temporada, String temperatura, String oxigenacion, boolean dificultad_respirar, boolean contagiado) {
        this.temporada = temporada;
        this.temperatura = temperatura;
        this.oxigenacion = oxigenacion;
        this.dificultad_respirar = dificultad_respirar;
        this.contagiado = contagiado;
    }

    public String getTemporada() {
        return temporada;
    }

    public void setTemporada(String temporada) {
        this.temporada = temporada;
    }

    public String getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(String temperatura) {
        this.temperatura = temperatura;
    }

    public String getOxigenacion() {
        return oxigenacion;
    }

    public void setOxigenacion(String oxigenacion) {
        this.oxigenacion = oxigenacion;
    }

    public boolean isDificultad_respirar() {
        return dificultad_respirar;
    }

    public void setDificultad_respirar(boolean dificultad_respirar) {
        this.dificultad_respirar = dificultad_respirar;
    }

    public String isContagiado() {
        return contagiado ? "yes" : "no";
    }

    public void setContagiado(boolean contagiado) {
        this.contagiado = contagiado;
    }

    @Override
    public String toString() {
        return "DataModel{" +
                "temporada='" + temporada + '\'' +
                ", temperatura='" + temperatura + '\'' +
                ", oxigenacion='" + oxigenacion + '\'' +
                ", dificultad_respirar=" + dificultad_respirar +
                ", contagiado=" + contagiado +
                '}';
    }
}
