import java.util.Scanner;
import java.util.Arrays;

public class LeagueBot
{

    // BAD_WORDS array
    private static final String[] BAD_WORDS = {
            "idiot","stupid","fool","dumb","shit","fuck","bitch","asshole","nigger","whore","bastard","slut","cunt",
        "penis","vagina","cock","dick","motherfucker","fucker","wtf","crap","piss","pissed","twat","jackass","moron",
        "pussy","faggot","retard","wanker","arse","damn","hoe","junkie","terrorist","virus","scum","porn","boobs",
        "hitler","nazi","rapist","raped","rape","bullshit","balls","dickhead","schlong","fisting","spank"
    };

    // ROLES array
    private static final String[] ROLES = {
        "top", "mid", "adc"
    };

    // CLASS_TYPE array
    private static final String[] CLASS_TYPE = {
        "bruiser", "ranged", "tank", "mage", "assassin", "marksman"
    };

    // Champions array
    private static final String[] Champion = {
        "sett", "mordekaiser", "jax", "garen", "kled", "riven", "fiora", "yorick", "darius", "aatrox",
        "renekton", "irelia", "camille", "malphite", "mundo", "sion", "chogath", "ornn", "shen", "maokai",
        "takm", "vayne", "quinn", "gnar", "kennen", "jayce", "teemo", "ekko", "katarina", "fizz", "talon",
        "akali", "zed", "qiyana", "syndra", "lux", "aurora", "mel", "viktor", "ahri", "anivia", "orianna",
        "zoe", "xerath", "ezreal", "draven", "kai'sa", "jinx", "lucian", "missfortune", "aphelios", "samira",
        "ashe", "caitlyn", "tristana", "jhin", "xayah", "twitch", "zeri", "sivir", "kogmaw", "varus"
    };

    // GAME_MODE array
    private static final String[] GAME_MODE = {
        "draft", "arena", "ranked", "aram", "nexus blitz", "tft", "urf", "swiftplay"
    };

    // --- Helper method to check a single input for curse words ---
    private static boolean containsCurse(String input)
    {
        if (input == null || input.isEmpty())
        {
            return false;
        }
        // Split input by whitespace to check each word
        String[] words = input.toLowerCase().split("\\s+");
        for (String word : words)
        {
            for (String curse : BAD_WORDS)
            {
                if (word.equals(curse))
                {
                    return true;
                }
            }
        }
        return false;
    }

    // Composite method to check any of the given inputs
    public static boolean CurseWords(String name, String role, String classType, String character, String gamemode)
    {
        return containsCurse(name) || containsCurse(role) || containsCurse(classType)
               || containsCurse(character) || containsCurse(gamemode);
    }

    // --- Validation Methods ---

    private static boolean isValidRole(String role)
    {
        return Arrays.stream(ROLES).anyMatch(r -> r.equalsIgnoreCase(role));
    }

    private static boolean isValidClassification(String classType)
    {
        return Arrays.stream(CLASS_TYPE).anyMatch(ct -> ct.equalsIgnoreCase(classType));
    }

    private static boolean isValidChamp(String champ)
    {
        return Arrays.stream(Champion).anyMatch(c -> c.equalsIgnoreCase(champ));
    }

    private static boolean isValidGamemode(String gamemode)
    {
        // Remove spaces for comparison
        return Arrays.stream(GAME_MODE).anyMatch(gm -> gm.equalsIgnoreCase(gamemode));
    }

    // (Optional) Champion check method
    public static boolean isChampion(String character)
    {
        return Arrays.stream(Champion).anyMatch(c -> c.equalsIgnoreCase(character));
    }

    // --- Response Methods ---

    private static void roles(String role, String name, String BotName)
    {
        switch (role)
        {
            case "top" ->
                System.out.println(BotName + ": That is my favorite role, summoner " + name +
                                   "! What class do you like to play, summoner " + name + "?");
            case "mid" ->
                System.out.println(BotName + ": What an excellent choice, summoner " + name +
                                   "! What class do you like to play, summoner " + name + "?");
            case "adc" ->
                System.out.println(BotName + ": That is my least favorite role, summoner " + name +
                                   "... What class do you like to play, summoner " + name + "?");
            default ->
                System.out.println(BotName + ": I don't recognize that role, summoner " + name + ".");
        }
    }

    private static void classification(String classType, String name, String BotName)
    {
        switch (classType)
        {
            case "bruiser" ->
                System.out.println(BotName + ": So you like fighter champions, summoner " + name +
                                   "! Those are my favorites <3. Can you tell me your favorite champion?");
            case "tank" ->
                System.out.println(BotName + ": So you like to tank damage for your team, summoner " + name +
                                   "! That is a great choice <3. Can you tell me your favorite champion?");
            case "ranged" ->
                System.out.println(BotName + ": So you like to take out your enemies from afar, summoner " + name +
                                   "! Great choice! Can you tell me your favorite champion?");
            case "mage" ->
                System.out.println(BotName + ": So you like mages, summoner " + name +
                                   "! Great choice! Can you tell me your favorite champion?");
            case "assassin" ->
                System.out.println(BotName + ": So you like midlane champions, summoner " + name +
                                   "! Those are my second favorites! Can you tell me your favorite champion?");
            case "marksman" ->
                System.out.println(BotName + ": So you like AD carry champions, summoner " + name +
                                   "! Those are my least favorite! :C Can you tell me your favorite champion?");
            default ->
                System.out.println(BotName + ": I don't recognize that class type, summoner " + name + ".");
        }
    }

    private static void characters(String character, String name, String BotName)
    {
        switch (character)
        {
            case "sett", "mordekaiser", "jax", "garen", "kled", "riven", "yorick", "darius", "aatrox",
                 "renekton", "irelia", "camille" ->
                System.out.println(BotName + ": That is an excellent choice, summoner " + name +
                                   "! My favorite bruiser champion is Fiora :) I wanted to ask you, what is your favorite gamemode?");
            //--
            case "fiora"  ->
                    System.out.println(BotName + ": That is an excellent choice, summoner " + name +
                            "! My favorite bruiser champion ALSO is Fiora :) I wanted to ask you, what is your favorite gamemode?");
            //--
            case "malphite", "mundo", "chogath", "ornn", "shen", "maokai", "takmkench" ->
                System.out.println(BotName + ": That is an excellent choice, summoner " + name +
                                   "! My favorite tank champion is Sion :) I wanted to ask you, what is your favorite gamemode?");
            //---
            case "sion" -> System.out.println(BotName + ": That is an excellent choice, summoner " + name +
                    "! My favorite tank champion is ALSO Sion :) I wanted to ask you, what is your favorite gamemode?");
            //---
            case "vayne", "quinn", "gnar", "kennen", "jayce" ->
                System.out.println(BotName + ": That is an excellent choice, summoner " + name +
                                   "! My favorite ranged champion is Teemo :) I wanted to ask you, what is your favorite gamemode?");
            //---
            case "teemo" ->  System.out.println(BotName + ": That is an excellent choice, summoner " + name +
                    "! My favorite ranged champion is ALSO Teemo :) I wanted to ask you, what is your favorite gamemode?");
            //--
            case "ekko", "katarina", "fizz", "talon", "zed", "qiyana" ->
                System.out.println(BotName + ": That is an excellent choice, summoner " + name +
                                   "! My favorite assassin is Akali :P I wanted to ask you, what is your favorite gamemode?");
            //--
            case "akali" -> System.out.println(BotName + ": That is an excellent choice, summoner " + name +
                    "! My favorite assassin is ALSO Akali :P I wanted to ask you, what is your favorite gamemode?");
            //--
            case "syndra", "lux", "aurora", "mel", "viktor", "ahri", "anivia", "zoe", "xerath" ->
                System.out.println(BotName + ": That is an excellent choice, summoner " + name +
                                   "! My favorite mage is Orianna :P I wanted to ask you, what is your favorite gamemode?");
            //--
            case "orianna" ->System.out.println(BotName + ": That is an excellent choice, summoner " + name +
                    "! My favorite mage is ALSO Orianna :P I wanted to ask you, what is your favorite gamemode?");
            //--
            case "ezreal", "kai'sa", "jinx", "lucian", "missfortune", "aphelios", "samira", "ashe",
                 "caitlyn", "tristana", "jhin", "xayah", "twitch", "zeri", "sivir", "kogmaw", "varus" ->
                System.out.println(BotName + ": That is an excellent choice, summoner " + name +
                                   "! My favorite marksman is Draven :D I wanted to ask you, what is your favorite gamemode?");
            //--
            case "draven" -> System.out.println(BotName + ": That is an excellent choice, summoner " + name +
                    "! My favorite marksman is ALSO Draven :D I wanted to ask you, what is your favorite gamemode?");
            //--
            default ->
                System.out.println(BotName + ": Sorry summoner, I don't know that champion.");
        }
    }

    private static void gamemodes(String name, String BotName, String gamemode)
    {
        switch (gamemode)
        {
            case "draft", "ranked", "aram", "urf", "tft", "nexus blitz", "swiftplay" ->
                System.out.println(BotName + ": Nice choice, summoner " + name +
                                   "! My favorite gamemode is arena :)");
            case "arena" ->
                System.out.println(BotName + ": Nice choice, summoner " + name +
                                   "! My favorite gamemode is also arena :D ");
            default ->
                System.out.println(BotName + ": I don't recognize that gamemode, summoner " + name + ".");
        }
    }

    //MAIN
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⠔⢪⣟⣩⡤⠄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⡶⠁⠐⠿⠚⠓⠒⠤⢄⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⢣⡇⠀⠀⠀⠀⠀⠀⢀⡴⠋⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢇⠃⠀⠀⢀⣀⣠⣖⣩⠀⠀⠀⠀⠀⠀⠀⠀⡔⢹");
        System.out.println("⢰⠤⣄⣀⠀⣀⡤⠖⠛⠉⠉⠙⠓⠶⣄⡀⣤⣤⢒⣱⡤⢀⠀⠐⣦⡖⠤⣸⠀⢸");
        System.out.println("⢸⠞⠒⣬⠟⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⢾⡅⢰⠙⠮⣰⡳⠶⢄⡉⣺⠇⠀⡎");
        System.out.println("⠸⣦⣠⣭⢵⡖⡦⢄⠀⣀⡤⠤⠤⢀⣀⡠⠌⢳⣼⠀⢀⡞⠀⠀⠀⢈⣾⠀⡸⠁");
        System.out.println("⠀⢹⡿⠎⡜⡰⢡⣃⠀⣃⡐⠛⠋⠁⠀⢻⣸⣀⡇⢀⠎⠀⠀⢀⡴⠁⠇⢠⠃⠀");
        System.out.println("⠀⡎⠺⠴⡠⢡⠧⠀⣀⣹⢃⢇⡀⠀⠤⠼⠆⡦⣇⡞⠀⠀⣠⠊⠫⣽⢀⠏⠀⠀");
        System.out.println("⠠⣞⡉⠉⠑⠃⠀⠀⠀⠘⠚⠒⠒⠂⠈⢉⣉⣠⡼⠁⠀⡰⠁⠀⢀⠇⠎⠀⠀⠀            HELLO SUMMONER!");
        System.out.println("⠀⢀⣽⡹⠫⠙⠀⠀⢰⢒⠖⠒⠦⠉⠉⡇⠀⢘⣳⣦⡜⠁⢀⣠⣞⢸⠀⠀⠀⠀         I AM THE LEAGUE BOT!");
        System.out.println("⠰⣞⡀⠑⠄⣱⠀⣀⡸⣈⠀⣀⣀⠠⠔⠁⢀⡴⠾⠴⢀⡠⡋⢰⢀⠟⠀");
        System.out.println("⠀⠈⠳⡀⠀⠘⡢⠤⠜⣀⠔⠀⠀⠀⠀⡰⠿⣿⡄⣀⣼⡢⢞⡎⡸⠀⠀⠀⠀⠀           1 - Questions");
        System.out.println("⠀⢀⣠⡾⠓⠦⠤⣉⣉⣀⣀⣀⠠⠴⠊⠀⢨⣾⠳⡕⣌⣢⡜⠀⣇                2 - Start!");
        System.out.println("⢠⠎⠸⣏⡠⣾⡀⠀⢾⠀⠀⠀⠀⡀⠀⣤⠞⠉⢠⠁⢸⠋⢈⠏⢨⠇⠀⠀⠀⠀           3 - Re-name me :)");
        System.out.println("⠈⢢⣀⠏⠀⠋⠻⢾⣌⣆⣰⣰⣤⣷⣛⡼⠶⣖⡁⢀⢧⡤⠊⠀⡎⠀⠀⠀⠀⠀           4 - Exit");
        System.out.println("⠀⢏⠘⢦⣀⠀⠀⠀⢹⣗⠻⡉⠁⠸⡁⢀⣀⣈⠟⠋⢹⢩⠖⠈⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠉⡟⣖⠿⢥⣴⡃⠈⢆⠰⣀⣀⠿⣻⡟⠀⠀⣠⠋⡇⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠘⢌⠁⢒⡞⠑⠤⢼⣦⢞⡣⠞⠁⡇⠀⠀⡏⢹⠃⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⣠⡁⠤⠌⠀⠀⠀⠈⠀⠑⠄⠀⢸⠀⠀⠀⠇⡏⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠈⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⢂⠈⠢⣀⠞⠀⡁⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠉⢹⣀⣠⠃       ⠀⠀");

        String name;
        String BotName = "LeagueBot";
        int Brazil = 5; // if you curse, it's off to the shadow realm of Brazil.

        // MAIN MENU LOOP
        while (true)
        {
            System.out.println(BotName + ": Enter mode: 1 for Questions, 2 to Start, 3 to change my name or 4 to exit");
            int mode = scanner.nextInt();
            scanner.nextLine(); // consume the leftover newline

            if (mode == 1)
            {
                System.out.println(BotName + ": 1) I can talk about roles! (Type one of the roles: Top, Mid, Adc)");
                System.out.println(BotName + ": 2) I can talk about champion classes! (Type one of the classes: Bruiser, Ranged, Tank, Mage, Assassin, Marksman)");
                System.out.println(BotName + ": 3) I can talk about champions! (Type one of your favorite champions from Top, Mid or Adc class)");
                System.out.println(BotName + ": 4) I can talk about gamemodes! (Type one of the gamemodes: Draft, Aram, Ranked, NexusBlitz, Arena, Tft)");
                System.out.println(BotName + ": 5) Please don't use commas or spaces if you are writing something to me! :D");
                System.out.println(BotName + ": 6) DO NOT, I REPEAT DO NOT USE CURSE WORDS. YOU HAVE BEEN WARNED...");
                System.out.println(BotName + ": Press 2 to start!");
            }
            else if (mode == 2)
            {
                break;
            }
            else if (mode == 3)
            {
                System.out.println("What would you like to change my name to, summoner?");
                BotName = scanner.nextLine();
                System.out.println("So my name is " + BotName + ", summoner. I like it!!!");
                System.out.println(BotName + ": Press 2 to start!");
            }
            else if (mode == 4)
            {
                scanner.close();
                return;
            }
            else
            {
                System.out.println("Please enter 1, 2, 3 or 4.");
            }
        }

        // NAME ENTRY
        while (true)
        {
            System.out.println(BotName + ": Please enter your name, summoner:");
            name = scanner.nextLine().trim();
            if (!name.isEmpty() && !containsCurse(name))
            {
                break;
            }
            else if (containsCurse(name))
            {
                System.out.println(BotName + ": Please do not use curse words in your name.");
                Brazil--;
                if (Brazil == 0)
                {
                    BotName = "Mordekaiser";
                    System.out.println(BotName + ": I have told you not to use curse words... Off to the shadow realm of Brazil with you.");
                    scanner.close();
                    return;
                }
            }
            else
            {
                System.out.println(BotName + ": Please enter your name.");
            }
        }

        // CONVERSATION LOOP
        boolean exit = false;
        while (!exit)
        {
            System.out.println(BotName + ": Hello summoner " + name + "! I wanted to ask you, what is your favorite role? :D");
            String role, classType, character, gamemode;

            // Role selection
            while (true)
            {
                role = scanner.nextLine().toLowerCase();
                if (role.equals("exit"))
                {
                    System.out.println(BotName + ": Goodbye summoner " + name + "! I hope we shall meet again!");
                    scanner.close();
                    return;
                }
                else if (isValidRole(role) && !CurseWords("", role, "", "", ""))
                {
                    roles(role, name, BotName);
                    break;
                }
                else if (CurseWords("", role, "", "", ""))
                {
                    System.out.println(BotName + ": Please do not use curse words while typing your role, summoner " + name);
                    Brazil--;
                    if (Brazil == 0)
                    {
                        BotName = "Mordekaiser";
                        System.out.println(BotName + ": I have told you not to use curse words... Off to Brazil with you.");
                        scanner.close();
                        return;
                    }
                }
                else
                {
                    System.out.println(BotName + ": Sorry summoner, I don't know that role. Please try again.");
                }
            }

            // Classification selection
            while (true)
            {
                classType = scanner.nextLine().toLowerCase();
                if (classType.equals("exit"))
                {
                    System.out.println(BotName + ": Goodbye summoner " + name + "! I hope we shall meet again!");
                    scanner.close();
                    return;
                }
                else if (isValidClassification(classType) && !CurseWords("", "", classType, "", ""))
                {
                    classification(classType, name, BotName);
                    break;
                }
                else if (CurseWords("", "", classType, "", ""))
                {
                    System.out.println(BotName + ": Please do not use curse words while typing your class, summoner " + name);
                    Brazil--;
                    if (Brazil == 0)
                    {
                        BotName = "Mordekaiser";
                        System.out.println(BotName + ": I have told you not to use curse words... Off to Brazil with you.");
                        scanner.close();
                        return;
                    }
                }
                else
                {
                    System.out.println(BotName + ": Sorry summoner, I don't know that class. Please try again.");
                }
            }

            // Champion selection
            while (true)
            {
                character = scanner.nextLine().toLowerCase();
                if (character.equals("exit"))
                {
                    System.out.println(BotName + ": Goodbye summoner " + name + "! I hope we shall meet again!");
                    scanner.close();
                    return;
                }
                else if (isValidChamp(character) && !CurseWords("", "", "", character, ""))
                {
                    characters(character, name, BotName);
                    break;
                }
                else if (CurseWords("", "", "", character, ""))
                {
                    System.out.println(BotName + ": Please do not use curse words while typing your champion, summoner " + name);
                    Brazil--;
                    if (Brazil == 0)
                    {
                        BotName = "Mordekaiser";
                        System.out.println(BotName + ": I have told you not to use curse words... Off to Brazil with you.");
                        scanner.close();
                        return;
                    }
                }
                else
                {
                    System.out.println(BotName + ": Sorry summoner, I don't know that champion. Please try again.");
                }
            }

            // Gamemode selection
            while (true)
            {
                gamemode = scanner.nextLine().toLowerCase();
                if (gamemode.equals("exit"))
                {
                    System.out.println(BotName + ": Goodbye summoner " + name + "! I hope we shall meet again!");
                    scanner.close();
                    return;
                }
                else if (isValidGamemode(gamemode) && !CurseWords("", "", "", "", gamemode))
                {
                    gamemodes(name, BotName, gamemode);
                    break;
                }
                else if (CurseWords("", "", "", "", gamemode))
                {
                    System.out.println(BotName + ": Please do not use curse words while typing your gamemode, summoner " + name);
                    Brazil--;
                    if (Brazil == 0)
                    {
                        BotName = "Mordekaiser";
                        System.out.println(BotName + ": I have told you not to use curse words... Off to Brazil with you.");
                        scanner.close();
                        return;
                    }
                }
                else
                {
                    System.out.println(BotName + ": Sorry summoner, I don't know that gamemode. Please try again.");
                }
            }
        }
    }
}
