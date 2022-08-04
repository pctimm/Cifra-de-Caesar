import java.util.Arrays;
import static pctimm.fun.caesar.CifraDeCaesar.*;

public class Main {

    public static void main(String[] args) {
        demonstracao();
    }

    private static void demonstracao() {
        System.out.println("Criptografando 'batata' -> + 3");
        String cripto = criptografar("batata", 3);
        System.out.println(cripto);
        System.out.println("Descriptografando 'edwdwd' -> + 3");
        String decripto = descriptografar("edwdwd", 3);
        System.out.println(decripto);
        System.out.println("Encontrar chave de criptografia entre 'batata' e 'edwdwd'");
        int chave = encontrarChave("batata", "edwdwd");
        System.out.println(chave);
        System.out.println("Todas possibilidades de descriptografia de 'edwdwd'");
        System.out.println(Arrays.toString(descriptografarTudo("edwdwd")));
    }

}
