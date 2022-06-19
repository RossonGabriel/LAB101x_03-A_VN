package lab12StringToken;

import java.util.*;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your content:");
        String userContent = scanner.nextLine();

        /* Split words and characters to calculate number */
        StringTokenizer wordsTokenizer = new StringTokenizer(userContent.replaceAll("\\W", " "));
        StringTokenizer charsTokenizer = new StringTokenizer(userContent.replaceAll("", " "));

        HashMap<String, Long> wordsCount = calculateTokens(wordsTokenizer);
        HashMap<String, Long> charsCount = calculateTokens(charsTokenizer);
        System.out.println(wordsCount);
        System.out.println(charsCount);
    }

    private static HashMap<String, Long> calculateTokens(StringTokenizer stringTokenizer) {
        ArrayList<String> tokens = new ArrayList();
        while (stringTokenizer.hasMoreTokens()) {
            tokens.add(stringTokenizer.nextToken());
        }

        HashMap<String, Long> result = new HashMap();
        ArrayList<String> alreadyCountTokens = new ArrayList<>();

        /* Loop through the list of tokens and count number
           mark it as already count to not be duplicated */
        tokens.forEach(token -> {
            boolean isAlreadyCounted = alreadyCountTokens.stream().anyMatch(elm -> elm.equals(token));
            if (!isAlreadyCounted) {
                Long count = tokens
                        .stream()
                        .filter(elm -> elm.equals(token))
                        .count();

                result.put(token, count);
                alreadyCountTokens.add(token);
            }
        });

        return result;
    }
}
