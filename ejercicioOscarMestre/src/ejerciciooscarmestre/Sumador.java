
package ejerciciooscarmestre;

public class Sumador {
    public int sumar(int n1, int n2){
        int resultado=0;
        for (int i=n1;i<=n2;i++){
            resultado=resultado+i;
        }
        return resultado;
    }

    public static void main(String[] args){
        if(args.length < 2){
            System.out.println("Necesita dos argumentos numéricos.");
            System.exit(1);
        }

        try {
            int n1 = Integer.parseInt(args[0]);
            int n2 = Integer.parseInt(args[1]);

            Sumador sumador = new Sumador();
            System.out.println(sumador.sumar(n1, n2));

        } catch(NumberFormatException e){
            System.out.println("Los argumentos deben ser enteros.");
            System.exit(1);
        }
    }
}
