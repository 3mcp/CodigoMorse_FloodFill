public class Main {
    public static void main(String[] args) {
        ArvoreMorse arvoreMorse = new ArvoreMorse();
        
        arvoreMorse.imprimirSequenciaInsercao();

        String fraseMorse = ".... . .-.. .-.. --- / .-- --- .-. .-.. -..";
        String resultado = arvoreMorse.decodificarFrase(fraseMorse);

        System.out.println("Frase decodificada: " + resultado);
    }
}