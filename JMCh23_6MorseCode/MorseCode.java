import java.util.TreeMap;


/**
 * http://205.173.41.10/lessons/Ch23-BinaryTrees/Ch23.html#(7)
 * http://lynbrook.schoolloop
 * .com/file/1250744497614/1187762038519/5240238451001382910.pdf
 * http://205.173.41.10/ICTLessons/LessonAB30/index.html
 * @author Jessica Jiang
 * @version February 2, 2015
 * @author Period - 4
 * @author Assignment - TODO Assignment Name
 * @author Sources - TODO list collaborators
 */
public class MorseCode
{
    private static final char DOT = '.';

    private static final char DASH = '-';

    private static TreeMap<Character, String> codeMap;

    private static TreeNode<Character> decodeTree;


    public static void start()
    {
        codeMap = new TreeMap<Character, String>();

        // put a space in the root of the decoding tree
        decodeTree = new TreeNode<Character>( ' ', null, null ); // autoboxing

        addSymbol( 'A', ".-" );
        addSymbol( 'B', "-..." );
        addSymbol( 'C', "-.-." );
        addSymbol( 'D', "-.." );
        addSymbol( 'E', "." );
        addSymbol( 'F', "..-." );
        addSymbol( 'G', "--." );
        addSymbol( 'H', "...." );
        addSymbol( 'I', ".." );
        addSymbol( 'J', ".---" );
        addSymbol( 'K', "-.-" );
        addSymbol( 'L', ".-.." );
        addSymbol( 'M', "--" );
        addSymbol( 'N', "-." );
        addSymbol( 'O', "---" );
        addSymbol( 'P', ".--." );
        addSymbol( 'Q', "--.-" );
        addSymbol( 'R', ".-." );
        addSymbol( 'S', "..." );
        addSymbol( 'T', "-" );
        addSymbol( 'U', "..-" );
        addSymbol( 'V', "...-" );
        addSymbol( 'W', ".--" );
        addSymbol( 'X', "-..-" );
        addSymbol( 'Y', "-.--" );
        addSymbol( 'Z', "--.." );
        addSymbol( '0', "-----" );
        addSymbol( '1', ".----" );
        addSymbol( '2', "..---" );
        addSymbol( '3', "...--" );
        addSymbol( '4', "....-" );
        addSymbol( '5', "....." );
        addSymbol( '6', "-...." );
        addSymbol( '7', "--..." );
        addSymbol( '8', "---.." );
        addSymbol( '9', "----." );
        addSymbol( '.', ".-.-.-" );
        addSymbol( ',', "--..--" );
        addSymbol( '?', "..--.." );
    }


    /**
     * Inserts a letter and its Morse code string into the encoding map and
     * calls treeInsert to insert them into the decoding tree.
     */
    private static void addSymbol( char letter, String code )
    {
        codeMap.put( letter, code );
        treeInsert( letter, code );
    }


    /**
     * Inserts a letter and its Morse code string into the decoding tree. Each
     * dot-dash string corresponds to a path in the tree from the root to a
     * node: at a "dot" go left, at a "dash" go right. The node at the end of
     * the path holds the symbol for that code string.
     */
    private static void treeInsert( char letter, String code )
    {
        TreeNode<Character> head = decodeTree;
        char[] array = code.toCharArray();
        for ( char c : array )
        {
            if ( c == DOT )
            {
                if ( head.getLeft() == null )
                {
                    head.setLeft( new TreeNode<Character>( ' ', null, null ));
                }
                head = head.getLeft();
            }
            if ( c == DASH)
            {
                if (head.getRight() == null)
                {
                    head.setRight( new TreeNode<Character>( ' ', null, null ));
                }
                head = head.getRight();
            }
        }
        head.setValue(letter);
        head = decodeTree;
    }


    /**
     * Converts text into a Morse code message. Adds a space after a dot-dash
     * sequence for each letter. Other spaces in the text are transferred
     * directly into the encoded message.
     * 
     * @return the encoded message.
     */
    public static String encode( String text )
    {
        StringBuffer morse = new StringBuffer( 400 );
        System.out.println( morse + " " );
        char[] array = text.toUpperCase().toCharArray();
        for ( char c: array)
        {
            if( codeMap.containsKey( c ))
            {
                morse.append( codeMap.get( c ) + " " );
            }
            else
            {
                morse.append(" ");
            }
        }

        return morse.toString();
    }


    /**
     * Converts a Morse code message into a text string. Assumes that dot-dash
     * sequences for each letter are separated by one space. Additional spaces
     * are transferred directly into text.
     * 
     * @return the plain text message.
     */
    public static String decode( String morse )
    {
        StringBuffer text = new StringBuffer( 100 );

        String[] string = morse.split( "[\\s]" );
        for (String s: string)
        //for( int i = 0; i < morse.length(); i++)
        {
            if (s.equals( " " ))
            {
                text.append( " ");
            }
            else
            {
                char[] array = s.toCharArray();
                TreeNode<Character> head = decodeTree;
                for ( char c : array)
                {
                    if ( c == DOT)
                    {
                        head = head.getLeft();
                    }
                    if ( c == DASH)
                    {
                        head = head.getRight();
                    }
                }
                text.append( head.getValue());
            }
        }

        return text.toString();
    }


    // --------------------------------------------------------------------
    // For test purposes only. Not to be used in completing the assignment

    protected TreeMap<Character, String> getCodeMap()
    {
        return codeMap;
    }


    protected TreeNode<Character> getDecodeTree()
    {
        return decodeTree;
    }
}
