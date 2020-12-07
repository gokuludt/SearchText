import java.util.Scanner;

/**
 * @author Gokula Krishnan V (gokuludt@gmail.com Nov 27 2020)
 *
 */
public class SearchText {

	/**
	 * @param Search
	 *            Content and Search Key
	 */
	public static void main(String args[]) {

		Scanner input = new Scanner(System.in);
		System.out.print("Enter Search Content: ");
		String searchContent = input.nextLine();
		System.out.print("Enter Search Term: ");
		String searchKey = input.nextLine();
		searchContent = searchContent.toLowerCase();
		searchKey = searchKey.toLowerCase();

		int searchKeylength = searchKey.length();
		int count = 0;

		/**
		 * @param this
		 *            block will spilt the search content by word and count it
		 */
		String splitContent[] = searchContent.split("\\s+");
		for (int i = 0; i < splitContent.length; i++) {
			if (splitContent[i].equals(searchKey)) {
				count++;
			}
		}

		/**
		 * @param this
		 *            block will verify search content by char and count it
		 */
		if (count == 0) {
			int wordfirstIdx = searchContent.indexOf(searchKey);
			int wordlastIdx = searchContent.lastIndexOf(searchKey);
			String tempsearchContent = searchContent;
			while (wordlastIdx > 0) {
				if (tempsearchContent.equals("")) {
					break;
				}
				if (tempsearchContent.contains(searchKey)) {
					count++;
					wordfirstIdx = tempsearchContent.indexOf(searchKey);
					wordlastIdx = tempsearchContent.lastIndexOf(searchKey);
					if (wordfirstIdx == 0) {
						wordfirstIdx = tempsearchContent.indexOf(searchKey, wordfirstIdx);
						wordlastIdx = tempsearchContent.lastIndexOf(searchKey, wordlastIdx);
					}
					tempsearchContent = tempsearchContent.substring(wordfirstIdx + searchKeylength);
				} else {
					break;
				}
			}
		}
		System.out.println("************************************************************************************");
		System.out.println("The search Content is: " + searchContent);
		System.out.println("The search Key is: " + searchKey);
		System.out.println("The word '" + searchKey + "' occurs '" + count + "' times in the Search Content");
		System.out.println("************************************************************************************");

	}

}
