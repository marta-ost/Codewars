/*
DESCRIPTION:
Trigrams are a special case of the n-gram, where n is 3. One trigram is a continous sequence of 3 chars in phrase. Wikipedia

return all trigrams for the given phrase
replace spaces with underscore (_)
return an empty string for phrases shorter than 3

Example:

"the quick red" --> "the he_ e_q _qu qui uic ick ck_ k_r _re red"
*/

import java.util.stream.*;

public class Trigrams {
	public static String trigrams(String phrase) {
    return IntStream
      .range(0, phrase.length() - 2)
      .mapToObj(i -> phrase.substring(i, i + 3).replace(" ", "_"))
      .collect(Collectors.joining(" "));
	}
}