public class Anagram
{
    public static boolean  areAnagram(String s1, String s2)
    {
        String s1Letters = removeJunk(s1);
        String s2Letters = removeJunk(s2);

        s1Letters = s1Letters.toLowerCase();
        s2Letters = s2Letters.toLowerCase();

        s1Letters = sort(s1Letters);
        s2Letters = sort(s2Letters);

        return s1Letters.equals(s2Letters);
    }

        public static  String removeJunk(String s ){
            int stringLength = s.length();
            char c;
            StringBuilder modifiedString = new StringBuilder();
            for(int i=0;i<stringLength;i++){
                c = s.charAt(i);
                if(Character.isLetter(c)){
                    modifiedString.append(c);
                }
            }
                return modifiedString.toString();
            }


            protected static String sort(String string) {
                char[] charArray = string.toCharArray();

                java.util.Arrays.sort(charArray);

                return new String(charArray);
            }

            public static void main(String args[])
            {
                String s1 = "This is Anagram";
                String s2 = "Ana is this gram";

                if(areAnagram(s1,s2)){
                   System.out.println("Yes, they are anagrams");
                    }
                    else{
                        System.out.println("No, They are not anagrams");
                    }
            }
        }
