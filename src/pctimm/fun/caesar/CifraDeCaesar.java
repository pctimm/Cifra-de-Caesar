package pctimm.fun.caesar;

public class CifraDeCaesar {
    private static final int A_LOWERCASE = 97;
    private static final int Z_LOWERCASE = 122;
    private static final int QUANTIDADE_LETRAS_ALFABETO = 26;
    private static final int OFFSET_DO_CALCULO_DE_SOBREPASSE = 1;
    public static String criptografar(String palavra, int chave) {
        String criptografado = "";

        chave = calcularChave(chave);
        char[] array = palavra.toCharArray();
        for (char atual : array) {
            criptografado += (char) calcularCaractere(atual, chave);
        }
        return criptografado;
    }

    public static String descriptografar(String criptografado, int chave) {
        return criptografar(criptografado, - chave);
    }

    public static int encontrarChave(String original, String criptografado) {
        int calculo = criptografado.charAt(0) - original.charAt(0);
        int inverso = QUANTIDADE_LETRAS_ALFABETO + calculo;
        return calculo >= 0 ? calculo : inverso;
    }

    public static String[] descriptografarTudo(String criptografado) {
        String[] resultados = new String[QUANTIDADE_LETRAS_ALFABETO];
        for (int i = 0; i < QUANTIDADE_LETRAS_ALFABETO; i ++) {
            resultados[i] = descriptografar(criptografado, i);
        }
        return resultados;
    }

    private static int calcularChave(int chave) {
        int modulo = Math.abs(chave);
        boolean ehNegativo = chave < 0;
        int inteiro = modulo / QUANTIDADE_LETRAS_ALFABETO;
        int resultado = modulo - inteiro * QUANTIDADE_LETRAS_ALFABETO;
        return ehNegativo ? - resultado : resultado;
    }

    private static int calcularCaractere(char c, int incremento) {
        int ascii = (int) c + incremento;

        int calculado;
        if (ascii > Z_LOWERCASE) calculado = A_LOWERCASE + ascii - Z_LOWERCASE - OFFSET_DO_CALCULO_DE_SOBREPASSE;
        else if (ascii < A_LOWERCASE) calculado = Z_LOWERCASE - (A_LOWERCASE - ascii) + OFFSET_DO_CALCULO_DE_SOBREPASSE;
        else calculado = ascii;

        return calculado;
    }
}
