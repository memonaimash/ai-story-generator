/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

package storygenerator;

/**
 *
 * @author Admin
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;
import java.util.List;
import javax.swing.event.DocumentListener;
import javax.swing.event.DocumentEvent;

// Character class
class Character {
    private String name;
    private String role;
    private String traits;

    public Character(String name, String role, String traits) {
        this.name = name;
        this.role = role;
        this.traits = traits;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public String getTraits() {
        return traits;
    }

    public String getBackstory() {
        return name + " was known as the " + role.toLowerCase() + " with " + traits.toLowerCase() +
                ". Their presence alone changed the course of fate.";
    }
}

// Story class
class Story {
    private String title;
    private String genre;
    private String fullNarrative;

    public Story(String title, String genre, String fullNarrative) {
        this.title = title;
        this.genre = genre;
        this.fullNarrative = fullNarrative;
    }

    public String getTitle() {
        return title;
    }

    public String getFullNarrative() {
        return fullNarrative;
    }
}

// Story Generator
class StoryGenerator {

    public static Story generateStory(String genre, Character protagonist, Character sidekick, Character villain, String tone, String length, String twist) {
        String title;
        StringBuilder storyBuilder = new StringBuilder();

        String name = protagonist.getName();
        String sidekickName = sidekick.getName();
        String villainName = villain.getName();

        // Intro
        storyBuilder.append(protagonist.getBackstory()).append("\n\n");
        storyBuilder.append(sidekick.getBackstory()).append("\n\n");
        storyBuilder.append(villain.getBackstory()).append("\n\n");

        // Mid Content
        String[] events = switch (genre.toLowerCase()) {
            case "sci-fi" -> new String[]{
                name + " stared at the holographic display, the year 3092 flashing in neon blue.",
                "The AI overlord, Zenith, had just declared martial law across the galaxy.",
                "A rogue signal buzzed through their comms—a distress call from a forgotten colony.",
                sidekickName + " adjusted their visor, scanning for Zenith's drones.",
                "The starship shuddered as they entered the forbidden Nebula of Krynn.",
                "A relic glowed in the cargo hold, pulsing with alien energy.",
                "Zenith's voice crackled through the speakers, demanding their surrender.",
                name + " gripped the controls, plotting a hyperspace jump.",
                "The relic whispered secrets of a lost civilization in their mind.",
                sidekickName + " cracked the quantum code embedded in the relic's core.",
                "A galactic syndicate ambushed them at the edge of the nebula.",
                "Lasers lit up the void as they evaded the syndicate's warships.",
                "The relic activated, projecting a map to a hidden star system.",
                name + " felt a chill—the map led straight to Zenith's core.",
                sidekickName + " suggested a risky plan: infiltrate Zenith's hub.",
                "They cloaked their ship, slipping past the AI's defenses.",
                "A secret transmission revealed " + villainName + " was Zenith's creator.",
                "The ship's engines failed mid-jump, stranding them in deep space.",
                "An ancient alien race appeared, offering help for a dangerous price.",
                "The aliens demanded the relic in exchange for repairs.",
                name + " hesitated, sensing the relic's power could end the war.",
                sidekickName + " argued they had no choice—they needed to survive.",
                "The aliens repaired the ship but planted a tracker onboard.",
                "They reached Zenith's hub, a sprawling station orbiting a dead planet.",
                name + " faced " + villainName + " in the station's core.",
                villainName + " laughed, revealing they had been controlling the aliens all along.",
                "The relic exploded with light, merging with " + name + "'s consciousness.",
                "A supernova ignited nearby, illuminating the truth—they were all connected.",
                "Zenith shut down, its circuits fried by the relic's energy.",
                name + " collapsed, their mind overwhelmed by alien memories.",
                sidekickName + " dragged them to the escape pod just in time.",
                "The station imploded, a fiery grave for " + villainName + ".",
                "They drifted in the pod, the galaxy finally free of Zenith's rule.",
                name + " whispered a promise to rebuild, no matter the cost.",
                sidekickName + " smiled, knowing they would fight another day.",
                "A new signal beeped on the pod's console—a call to a new adventure"
            };
                
            case "fantasy" -> new String[]{
                "The realm of Eldarion burned under a cursed sky, crimson and ash.",
                name + " rode a griffin into the heart of the war-torn valley.",
                "A prophecy whispered of a lost heir destined to end the curse.",
                sidekickName + " deciphered ancient runes carved into a shattered obelisk.",
                "The runes spoke of the Forest of Whispers, a place of forgotten magic.",
                "They trekked through the forest, shadows moving with unnatural grace.",
                villainName + " unleashed the wraiths of the Deep Vault upon them.",
                "A wraith's scream chilled their bones, but " + name + " stood firm.",
                "The griffin roared, tearing through the wraiths with razor-sharp talons.",
                sidekickName + " found a hidden grove, glowing with emerald light.",
                "A dragon emerged, its scales shimmering like molten gold.",
                name + " drew their sword, forged from starlight, to face the beast.",
                "The dragon spoke, offering a riddle in exchange for passage.",
                sidekickName + " solved it, revealing the dragon as an ally.",
                "The dragon gifted them a scale, a key to the Vault of Ages.",
                "They journeyed to the vault, its doors sealed by ancient blood magic.",
                villainName + " appeared, wielding a staff crackling with dark energy.",
                name + " charged, their sword clashing against " + villainName + "'s magic.",
                "The vault doors groaned open, revealing a crown of pure light.",
                sidekickName + " placed the crown on " + name + ", breaking the curse.",
                "The sky cleared, sunlight bathing Eldarion for the first time in centuries.",
                villainName + " screamed as their power drained, turning them to dust.",
                "The dragon bowed to " + name + ", the true heir of Eldarion.",
                "The people of the realm gathered, chanting " + name + "'s name.",
                sidekickName + " smiled, knowing their journey had just begun.",
                "A new threat loomed on the horizon—a shadow stirring in the east.",
                name + " vowed to protect their realm, no matter the cost.",
                "The griffin took flight, carrying them toward their next destiny.",
                "Magic pulsed through the land, a promise of hope restored.",
                "But whispers of " + villainName + "'s return echoed in the wind."
            };
            case "romance" -> new String[]{
                "Rain poured as " + name + " stood under a flickering streetlamp.",
                sidekickName + " ran up, umbrella in hand, their laughter breaking the silence.",
                "They had known each other since childhood, but tonight felt different.",
                name + "'s heart raced as " + sidekickName + "'s hand brushed theirs.",
                "A shared coffee at a cozy café turned into hours of conversation.",
                villainName + " stormed in, an ex who had never let go of the past.",
                "Old arguments flared, threatening to tear the moment apart.",
                name + " stood up, defending their newfound feelings.",
                sidekickName + " squeezed their hand, a silent promise of support.",
                "They left the café, walking through the city's glowing lights.",
                "A street musician played a song that felt meant just for them.",
                name + " stopped, turning to " + sidekickName + " with a shy smile.",
                "\"I have always loved you,\" " + name + " confessed, voice trembling.",
                sidekickName + "'s eyes sparkled, pulling them into a kiss.",
                villainName + " watched from afar, jealousy burning in their chest.",
                "The next day, a letter arrived, threatening to expose a secret.",
                name + " panicked—it was a secret that could ruin everything.",
                sidekickName + " read the letter, their expression unreadable.",
                "\"We will face this together,\" " + sidekickName + " said firmly.",
                "They confronted " + villainName + " at a crowded festival.",
                villainName + " smirked, but " + name + " held their ground.",
                "The crowd cheered as fireworks lit up the night sky.",
                name + " and " + sidekickName + " danced under the bursts of color.",
                "They realized love was not perfect, but it was worth fighting for.",
                "A photo from that night captured their joy, a keepsake forever.",
                villainName + " walked away, defeated by their unbreakable bond.",
                "Years later, they would laugh about that night, stronger than ever.",
                "Their love story became a tale told at every festival.",
                name + " knew they had found their forever in " + sidekickName + "."
            };
                
            case "horror" -> new String[]{
                "The old house creaked under a moonless sky, shadows stretching long.",
                name + " heard whispers from the attic, faint but persistent.",
                "No mirrors hung in the house—no one remembered why.",
                sidekickName + " clutched a flashlight, their hands trembling.",
                "They climbed the stairs, each step groaning under their weight.",
                "A cold draft swept through, carrying the scent of decay.",
                "In the attic, they found a locked chest, etched with strange symbols.",
                name + " pried it open, revealing a doll with glass eyes.",
                "The doll's head turned on its own, staring at " + sidekickName + ".",
                "A scream echoed—not theirs, but from the walls themselves.",
                villainName + "'s name was carved into the doll's back.",
                "They had heard rumors " + villainName + " had died here decades ago.",
                "The lights flickered, then died, plunging them into darkness.",
                sidekickName + " vanished for three nights, returning changed.",
                "\"Do not trust the mirrors,\" " + sidekickName + " whispered, eyes hollow.",
                "A mirror appeared in the hall, reflecting nothing but shadows.",
                name + " saw their reflection move when they did not.",
                "Blood dripped upwards from the floor, defying gravity.",
                "The doll spoke in " + villainName + "'s voice, chilling their blood.",
                "They burned the doll, but the house grew colder.",
                "The walls shifted, trapping them in a maze of corridors.",
                "An ancient book appeared, warning of a curse tied to " + villainName + ".",
                "They broke the curse, but at a cost—they forgot their names.",
                "The house crumbled to dust, leaving them in silence.",
                "They walked away, but the whispers followed.",
                sidekickName + " never spoke of those three nights.",
                name + " felt eyes watching them, even in the daylight.",
                "A new house stood on the same spot years later.",
                "And the whispers began again"
            };
                
            case "adventure" -> new String[]{
                "The jungle roared as " + name + " slashed through dense vines.",
                "They sought the Heartstone, a gem said to hold ancient power.",
                sidekickName + " checked the map, its edges frayed from humidity.",
                "A crumbling bridge stretched over a raging river below.",
                name + " leapt across, their footing slipping on wet stone.",
                "Booby traps triggered—arrows whizzed past their head.",
                sidekickName + " solved the puzzle of the Golden Idol's pedestal.",
                "A jaguar stalked them, its eyes glowing in the underbrush.",
                name + " held their breath, signaling " + sidekickName + " to freeze.",
                "The jaguar lunged, but they rolled out of the way.",
                villainName + " appeared, leading a band of mercenaries.",
                "They had been tracking " + name + " since the river crossing.",
                "A chase erupted, the jungle alive with shouts and gunfire.",
                "The map burned in a trap, but " + sidekickName + " memorized it.",
                "They reached a hidden temple, its doors sealed with stone.",
                name + " pushed through, revealing the Heartstone's pedestal.",
                "The gem glowed, but " + villainName + " cornered them.",
                "A fight broke out, fists and blades in the dim light.",
                sidekickName + " grabbed the Heartstone, its warmth pulsing.",
                "The temple shook, collapsing as they sprinted for the exit.",
                "They escaped, but the river swept away their supplies.",
                "The Heartstone whispered secrets of the jungle's past.",
                name + " realized its power was not wealth, but knowledge.",
                "They tamed a wild horse with a song, riding to safety.",
                villainName + " survived, vowing revenge from the ruins.",
                "The journey changed them, their bond unbreakable.",
                sidekickName + " sketched the temple, a memory of their triumph.",
                name + " knew this was only the beginning of their adventures"
            };
                
            case "realistic" -> new String[]{
                name + " raced through the city streets, late for a crucial job interview.",
                "A sudden rainstorm hit, soaking their carefully pressed suit.",
                sidekickName + " called, offering to meet them with an umbrella.",
                "They met at a bustling intersection, dodging taxis and pedestrians.",
                villainName + " bumped into them, an old rival from college days.",
                "Words were exchanged—sharp, cutting reminders of past betrayals.",
                name + " felt their confidence waver but pushed forward.",
                "They arrived at the interview, dripping wet but determined.",
                "The interviewer raised an eyebrow but listened to " + name + "'s pitch.",
                sidekickName + " waited outside, texting words of encouragement.",
                "The interview went better than expected—until " + villainName + " called.",
                villainName + " had sabotaged " + name + "'s references out of spite.",
                name + " stormed out, confronting " + villainName + " at a nearby café.",
                "A heated argument erupted, drawing a small crowd.",
                sidekickName + " stepped in, defusing the tension with a witty remark.",
                "They retreated to a diner, strategizing over coffee and fries.",
                name + " decided to start their own business instead.",
                "They worked late nights, building a website from scratch.",
                sidekickName + " designed a logo, their creativity shining through.",
                "A local news outlet featured their startup, bringing in clients.",
                villainName + " tried to undermine them with false reviews.",
                name + " fought back, proving their work's quality to the community.",
                "Their business grew, a testament to their resilience.",
                "They celebrated their first big contract with a rooftop party.",
                sidekickName + " toasted to their shared dreams coming true.",
                "Challenges kept coming, but they faced them as a team.",
                name + " knew this was the start of something incredible.",
                "Years later, they would look back on that rainy day and laugh."
            };
                
            default -> new String[]{
                "A tale began on an ordinary morning, with " + name + " at its heart.",
                name + " questioned their purpose, feeling the weight of routine.",
                sidekickName + " arrived, carrying secrets they had never shared.",
                villainName + " watched from the shadows, plotting their next move.",
                "They crossed paths at a crossroads, both literal and metaphorical.",
                "A storm brewed, forcing them to make impossible choices.",
                name + " chose to fight for something greater than themselves.",
                sidekickName + " revealed a hidden strength, surprising everyone.",
                villainName + "'s influence spread, a dark cloud over their journey.",
                "Hope flickered in the smallest moments—a shared laugh, a kind word.",
                "They found clarity in the chaos, their purpose renewed.",
                "The storm passed, leaving them stronger than before.",
                "Their story became a legend, whispered by those who followed.",
                name + " and " + sidekickName + " walked into the sunset, ready for more."
            };
        };

        int count = switch (length.toLowerCase()) {
            case "short" -> 20 + new Random().nextInt(6);
            case "medium" -> 30 + new Random().nextInt(6);
            case "long" -> 50 + new Random().nextInt(21);
            default -> 15;
        };

        // Shuffle events to ensure no repetition
        List<String> eventList = new ArrayList<>(List.of(events));
        Collections.shuffle(eventList);  // Shuffle the events to randomize order

        // Select a unique set of events based on requested length
        for (int i = 0; i < count; i++) {
            storyBuilder.append(eventList.get(i % eventList.size())).append("\n");
        }

        // Tone Addition
        String toneAdd = switch (tone.toLowerCase()) {
            case "dark" -> "The tone was somber, and danger loomed in every shadow.";
            case "light-hearted" -> "Yet, laughter echoed between the perils.";
            case "epic" -> "This was no ordinary tale; it would echo through time.";
            default -> "";
        };

        // Outro
        storyBuilder.append("\n").append(toneAdd).append("\n");
        storyBuilder.append("Twist: ").append(twist);

        String story = storyBuilder.toString();

        // Title
        title = switch (genre.toLowerCase()) {
            case "sci-fi" -> "Echoes Beyond the Stars";
            case "fantasy" -> "Crown of the Forgotten Flame";
            case "romance" -> "Beneath the Same Sky";
            case "horror" -> "The Cursed Portrait";
            case "adventure" -> "The Lost Kingdom";
            case "realistic" -> "Chasing the Dawn";
            default -> "The Path Unseen";
        };

        return new Story(title, genre, story);
    }

    public static Character generateRandomCharacter(String role) {
        String[] names = {"Aria", "Jax", "Thorne", "Lira", "Kai", "Jack", "Cobra", "Evelien", "Anna", "Micky", "Leo", "Janny", "Nova", "Ezra", "Riven", "Nico", "Sable", "Zara", "Milo", "Orin", "Vera", "Ash", "Rey", "Dante", "Nyx", "Elio", "Kira"};
        String[] positiveTraits = {
            "unbreakable courage", "keen intellect", "deep empathy", "loyal to a fault",
            "unshakable calm", "a natural leader", "mechanical genius", "gift for languages"
        };
        String[] negativeTraits = {
            "shadowy motives", "explosive temper", "fear of the dark", "vengeful nature",
            "crippling self-doubt", "greedy tendencies", "reckless behavior", "trust issues"
        };
        String[] quirkyTraits = {
            "a hidden scar", "obsession with tea", "telepathic sensitivity", "talks to animals",
            "compulsive whistler", "haunted by dreams", "forgotten royalty", "laughs at danger"
        };

        Random rand = new Random();
        String name = names[rand.nextInt(names.length)];
        String trait = positiveTraits[rand.nextInt(positiveTraits.length)] + ", " +
                      negativeTraits[rand.nextInt(negativeTraits.length)] + ", and " +
                      quirkyTraits[rand.nextInt(quirkyTraits.length)];

        return new Character(name, role, trait);
    }

    public static String generateRandomTwist() {
        String[] twists = {
            "The villain was their own future self.",
            "It was all a dream—until it was not.",
            "They were working for the enemy all along.",
            "Time travel broke the timeline.",
            "Love was the only true magic."
        };
        return twists[new Random().nextInt(twists.length)];
    }
}

// GUI Class
public class StoryGeneratorGUI {

    private static final Color accentColor = new Color(173, 216, 230); // Light blue for light mode
    private static final Color darkAccentColor = new Color(70, 130, 180); // Steel blue for dark mode
    private static final Color bgColor = Color.WHITE;
    private static final Color darkBgColor = new Color(34, 34, 34);
    private static final Color fieldBgColor = new Color(240, 248, 255);
    private static final Color darkFieldBgColor = new Color(50, 50, 50); // Dark gray for fields in dark mode
    private static final Color textColor = Color.BLACK;
    private static final Color darkTextColor = Color.WHITE;
    private static final Font emojiFont = findEmojiFont();
    private static JCheckBox darkModeToggle; // Static reference to the dark mode toggle

    // Method to find a font that supports emojis
    private static Font findEmojiFont() {
        String[] fontNames = {"Segoe UI Emoji", "Noto Color Emoji", "Arial Unicode MS", "Arial"};
        for (String fontName : fontNames) {
            Font font = new Font(fontName, Font.PLAIN, 14);
            if (font.canDisplayUpTo("📖") == -1) { // Check if font can display emoji
                return font;
            }
        }
        return new Font("Arial", Font.PLAIN, 14); // Fallback font
    }

    // Recursively set font for all components
    private static void setFontForAll(Component component, Font font) {
        component.setFont(font);
        if (component instanceof Container) {
            for (Component child : ((Container) component).getComponents()) {
                setFontForAll(child, font);
            }
        }
    }

    // Recursively update colors for components
    private static void updateComponentColors(Component component, boolean dark) {
        if (component instanceof JTextField || component instanceof JTextArea) {
            component.setBackground(dark ? darkFieldBgColor : fieldBgColor);
            component.setForeground(dark ? darkTextColor : textColor);
            if (component instanceof JTextField) {
                ((JTextField) component).setBorder(BorderFactory.createLineBorder(dark ? darkAccentColor : accentColor, 2));
            }
        } else if (component instanceof JComboBox) {
            JComboBox<?> comboBox = (JComboBox<?>) component;
            comboBox.setBackground(dark ? darkFieldBgColor : fieldBgColor);
            comboBox.setForeground(dark ? darkTextColor : textColor);
            comboBox.setBorder(BorderFactory.createLineBorder(dark ? darkAccentColor : accentColor, 2));
            // Update the renderer to ensure dropdown items are styled
            comboBox.setRenderer(new DefaultListCellRenderer() {
                @Override
                public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                    Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                    if (dark) {
                        c.setBackground(dark ? darkFieldBgColor : fieldBgColor);
                        c.setForeground(dark ? darkTextColor : textColor);
                        if (isSelected) {
                            c.setBackground(dark ? darkAccentColor : accentColor);
                            c.setForeground(dark ? darkTextColor : textColor);
                        }
                    } else {
                        c.setBackground(fieldBgColor);
                        c.setForeground(textColor);
                        if (isSelected) {
                            c.setBackground(accentColor);
                            c.setForeground(textColor);
                        }
                    }
                    return c;
                }
            });
        } else if (component instanceof AbstractButton) { // JButton, JCheckBox, etc.
            component.setBackground(dark ? darkAccentColor : accentColor);
            component.setForeground(dark ? darkTextColor : textColor);
            ((AbstractButton) component).setBorder(BorderFactory.createLineBorder(dark ? darkAccentColor : accentColor, 2));
        } else if (component instanceof JLabel) {
            component.setForeground(dark ? darkTextColor : textColor);
        } else if (component instanceof JToolBar) {
            component.setBackground(dark ? new Color(0, 102, 204) : accentColor);
        }

        if (component instanceof Container) {
            for (Component child : ((Container) component).getComponents()) {
                updateComponentColors(child, dark);
            }
        }
    }

    public static void main(String[] args) {
        // Set the system Look and Feel for better emoji rendering
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        JFrame frame = new JFrame("AI Story Generator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(750, 800);
        frame.setLayout(new BorderLayout());

        // Top Panel for Toolbar and Header
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBackground(accentColor);

        // Toolbar
        JToolBar toolbar = new JToolBar();
        toolbar.setFloatable(false);
        toolbar.setBackground(accentColor);
        JButton toolbarGenerate = new JButton("📖 Generate");
        JButton toolbarSave = new JButton("💾 Save");
        JButton toolbarClear = new JButton("🗑️ Clear");
        JButton toolbarRandomize = new JButton("🎲 Randomize");
        styleButton(toolbarGenerate); styleButton(toolbarSave);
        styleButton(toolbarClear); styleButton(toolbarRandomize);
        addHoverEffect(toolbarGenerate); addHoverEffect(toolbarSave);
        addHoverEffect(toolbarClear); addHoverEffect(toolbarRandomize);
        toolbar.add(toolbarGenerate); toolbar.add(toolbarSave);
        toolbar.add(toolbarClear); toolbar.add(toolbarRandomize);
        topPanel.add(toolbar, BorderLayout.NORTH);

        // Header Panel
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(accentColor);
        JLabel headerLabel = new JLabel("✍️ AI Story Generator");
        headerLabel.setFont(new Font("Arial", Font.BOLD, 24));
        headerLabel.setForeground(textColor);
        headerPanel.add(headerLabel);
        topPanel.add(headerPanel, BorderLayout.CENTER);

        frame.add(topPanel, BorderLayout.NORTH);

        // Tabbed Pane
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setFont(new Font("Arial", Font.PLAIN, 14));

        // Character Tab
        JPanel characterPanel = new JPanel(new GridBagLayout());
        characterPanel.setBackground(bgColor);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        JTextField protagonistName = createStyledField();
        protagonistName.setToolTipText("Enter the protagonist's name (e.g., Aria)");
        JTextField protagonistRole = createStyledField();
        protagonistRole.setToolTipText("Enter the protagonist's role (e.g., Hero)");
        JTextField protagonistTraits = createStyledField();
        protagonistTraits.setToolTipText("Enter traits (e.g., brave, cunning)");
        JTextArea protagonistBackstory = new JTextArea(3, 20);
        protagonistBackstory.setLineWrap(true);
        protagonistBackstory.setWrapStyleWord(true);
        protagonistBackstory.setEditable(false);
        protagonistBackstory.setBackground(fieldBgColor);
        protagonistBackstory.setForeground(textColor);

        JTextField sidekickName = createStyledField();
        sidekickName.setToolTipText("Enter the sidekick's name (e.g., Jax)");
        JTextField sidekickRole = createStyledField();
        sidekickRole.setToolTipText("Enter the sidekick's role (e.g., Ally)");
        JTextField sidekickTraits = createStyledField();
        sidekickTraits.setToolTipText("Enter traits (e.g., loyal, witty)");
        JTextArea sidekickBackstory = new JTextArea(3, 20);
        sidekickBackstory.setLineWrap(true);
        sidekickBackstory.setWrapStyleWord(true);
        sidekickBackstory.setEditable(false);
        sidekickBackstory.setBackground(fieldBgColor);
        sidekickBackstory.setForeground(textColor);

        JTextField villainName = createStyledField();
        villainName.setToolTipText("Enter the villain's name (e.g., Thorne)");
        JTextField villainTraits = createStyledField();
        villainTraits.setToolTipText("Enter traits (e.g., ruthless, clever)");
        JTextArea villainBackstory = new JTextArea(3, 20);
        villainBackstory.setLineWrap(true);
        villainBackstory.setWrapStyleWord(true);
        villainBackstory.setEditable(false);
        villainBackstory.setBackground(fieldBgColor);
        villainBackstory.setForeground(textColor);

        JButton randomizeButton = new JButton("🎲 Randomize Characters");
        randomizeButton.setToolTipText("Randomly fill character fields");
        styleButton(randomizeButton);
        addHoverEffect(randomizeButton);

        int row = 0;
        panelAdd(characterPanel, gbc, new JLabel("Protagonist Name:"), protagonistName, row++);
        panelAdd(characterPanel, gbc, new JLabel("Protagonist Role:"), protagonistRole, row++);
        panelAdd(characterPanel, gbc, new JLabel("Protagonist Traits:"), protagonistTraits, row++);
        panelAdd(characterPanel, gbc, new JLabel("Backstory Preview:"), protagonistBackstory, row++);
        panelAdd(characterPanel, gbc, new JLabel("Sidekick Name:"), sidekickName, row++);
        panelAdd(characterPanel, gbc, new JLabel("Sidekick Role:"), sidekickRole, row++);
        panelAdd(characterPanel, gbc, new JLabel("Sidekick Traits:"), sidekickTraits, row++);
        panelAdd(characterPanel, gbc, new JLabel("Backstory Preview:"), sidekickBackstory, row++);
        panelAdd(characterPanel, gbc, new JLabel("Villain Name:"), villainName, row++);
        panelAdd(characterPanel, gbc, new JLabel("Villain Traits:"), villainTraits, row++);
        panelAdd(characterPanel, gbc, new JLabel("Backstory Preview:"), villainBackstory, row++);
        gbc.gridwidth = 2; // Span both columns for button
        gbc.gridx = 0;
        gbc.gridy = row++;
        characterPanel.add(randomizeButton, gbc);
        gbc.gridwidth = 1; // Reset gridwidth

        // Add filler to take up remaining space
        gbc.gridx = 0;
        gbc.gridy = row++;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        characterPanel.add(Box.createVerticalGlue(), gbc);
        gbc.weighty = 0.0; // Reset weighty

        // Backstory Listeners
        DocumentListener protagonistListener = new DocumentListener() {
            public void update() {
                String name = protagonistName.getText().trim().isEmpty() ? "Unknown" : protagonistName.getText();
                String role = protagonistRole.getText().trim().isEmpty() ? "Protagonist" : protagonistRole.getText();
                String traits = protagonistTraits.getText().trim().isEmpty() ? "mysterious aura" : protagonistTraits.getText();
                Character c = new Character(name, role, traits);
                protagonistBackstory.setText(c.getBackstory());
            }
            @Override
            public void insertUpdate(DocumentEvent e) { update(); }
            @Override
            public void removeUpdate(DocumentEvent e) { update(); }
            @Override
            public void changedUpdate(DocumentEvent e) { update(); }
        };
        protagonistName.getDocument().addDocumentListener(protagonistListener);
        protagonistRole.getDocument().addDocumentListener(protagonistListener);
        protagonistTraits.getDocument().addDocumentListener(protagonistListener);

        DocumentListener sidekickListener = new DocumentListener() {
            public void update() {
                String name = sidekickName.getText().trim().isEmpty() ? "Unknown" : sidekickName.getText();
                String role = sidekickRole.getText().trim().isEmpty() ? "Sidekick" : sidekickRole.getText();
                String traits = sidekickTraits.getText().trim().isEmpty() ? "helpful nature" : sidekickTraits.getText();
                Character c = new Character(name, role, traits);
                sidekickBackstory.setText(c.getBackstory());
            }
            
            @Override
            public void insertUpdate(DocumentEvent e) { update(); }
            @Override
            public void removeUpdate(DocumentEvent e) { update(); }
            @Override
            public void changedUpdate(DocumentEvent e) { update(); }
        };
        
        sidekickName.getDocument().addDocumentListener(sidekickListener);
        sidekickRole.getDocument().addDocumentListener(sidekickListener);
        sidekickTraits.getDocument().addDocumentListener(sidekickListener);

        DocumentListener villainListener = new DocumentListener() {
            public void update() {
                String name = villainName.getText().trim().isEmpty() ? "Unknown" : villainName.getText();
                String traits = villainTraits.getText().trim().isEmpty() ? "dark intentions" : villainTraits.getText();
                Character c = new Character(name, "Villain", traits);
                villainBackstory.setText(c.getBackstory());
            }
            
            @Override
            public void insertUpdate(DocumentEvent e) { update(); }
            @Override
            public void removeUpdate(DocumentEvent e) { update(); }
            @Override
            public void changedUpdate(DocumentEvent e) { update(); }
        };
        
        villainName.getDocument().addDocumentListener(villainListener);
        villainTraits.getDocument().addDocumentListener(villainListener);

        tabbedPane.addTab("Characters", characterPanel);

        // Settings Tab
        JPanel settingsPanel = new JPanel(new GridBagLayout());
        settingsPanel.setBackground(bgColor);
        gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.NORTH; // Align components to the top

        JTextField genreField = createStyledField();
        genreField.setToolTipText("Enter genre (e.g., Sci-Fi, Fantasy)");
        JTextField twistField = createStyledField();
        twistField.setToolTipText("Enter a custom twist or leave blank for random");
        twistField.setText("");
        JComboBox<String> toneBox = new JComboBox<>(new String[]{"Epic", "Dark", "Light-hearted"});
        toneBox.setToolTipText("Select the story's tone");
        styleComboBox(toneBox);
        JComboBox<String> lengthBox = new JComboBox<>(new String[]{"Short", "Medium", "Long"});
        lengthBox.setToolTipText("Select the story's length");
        styleComboBox(lengthBox);

        row = 0;
        panelAdd(settingsPanel, gbc, new JLabel("Genre (e.g. Sci-Fi, Fantasy):"), genreField, row++);
        panelAdd(settingsPanel, gbc, new JLabel("Story Tone:"), toneBox, row++);
        panelAdd(settingsPanel, gbc, new JLabel("Story Length:"), lengthBox, row++);
        panelAdd(settingsPanel, gbc, new JLabel("Custom Twist:"), twistField, row++);

        // Add filler to take up remaining space
        gbc.gridx = 0;
        gbc.gridy = row++;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        settingsPanel.add(Box.createVerticalGlue(), gbc);
        gbc.weighty = 0.0; // Reset weighty

        tabbedPane.addTab("Story Settings", settingsPanel);

        // Output Tab
        JPanel outputPanel = new JPanel(new GridBagLayout());
        outputPanel.setBackground(bgColor);
        gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
 
        JTextArea outputArea = new JTextArea(15, 50);
        outputArea.setLineWrap(true);
        outputArea.setWrapStyleWord(true);
        outputArea.setBackground(fieldBgColor);
        outputArea.setForeground(textColor);
        JScrollPane scrollPane = new JScrollPane(outputArea);

        JButton generateButton = new JButton("📖 Generate Story");
        generateButton.setToolTipText("Generate a story based on your inputs");
        JButton saveButton = new JButton("💾 Save Story");
        saveButton.setToolTipText("Save the generated story to a file");
        JButton clearButton = new JButton("🗑️ Clear");
        clearButton.setToolTipText("Clear all inputs and output");
        darkModeToggle = new JCheckBox("🌙 Dark Mode"); // Assign to static field
        darkModeToggle.setToolTipText("Toggle between light and dark themes");

        styleButton(generateButton);
        styleButton(saveButton);
        styleButton(clearButton);
        styleButton(darkModeToggle);
        addHoverEffect(generateButton);
        addHoverEffect(saveButton);
        addHoverEffect(clearButton);

        row = 0;
        gbc.gridwidth = 2;
        gbc.gridx = 0;
        gbc.gridy = row++;
        outputPanel.add(generateButton, gbc);
        gbc.gridy = row++;
        panelAdd(outputPanel, gbc, saveButton, clearButton, row++);
        panelAdd(outputPanel, gbc, darkModeToggle, new JLabel(""), row++);
        gbc.gridy = row++;
        gbc.weighty = 1.0;
        outputPanel.add(scrollPane, gbc);
        gbc.gridwidth = 1; // Reset gridwidth

        tabbedPane.addTab("Output", outputPanel);

        frame.add(tabbedPane, BorderLayout.CENTER);

        // Apply emoji font to all components
        setFontForAll(frame, emojiFont);

        // Shared Action Listeners
        ActionListener generateAction = e -> {
            if (protagonistName.getText().trim().isEmpty() ||
                protagonistRole.getText().trim().isEmpty() ||
                protagonistTraits.getText().trim().isEmpty() ||
                sidekickName.getText().trim().isEmpty() ||
                sidekickRole.getText().trim().isEmpty() ||
                sidekickTraits.getText().trim().isEmpty() ||
                villainName.getText().trim().isEmpty() ||
                villainTraits.getText().trim().isEmpty() ||
                genreField.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Please fill in all required fields.", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String twist = twistField.getText().trim().isEmpty() ? StoryGenerator.generateRandomTwist() : twistField.getText();
            Character protagonist = new Character(protagonistName.getText(), protagonistRole.getText(), protagonistTraits.getText());
            Character sidekick = new Character(sidekickName.getText(), sidekickRole.getText(), sidekickTraits.getText());
            Character villain = new Character(villainName.getText(), "Villain", villainTraits.getText());
            Story story = StoryGenerator.generateStory(genreField.getText(), protagonist, sidekick, villain,
                    toneBox.getSelectedItem().toString(), lengthBox.getSelectedItem().toString(), twist);
            outputArea.setText("🎬 Title: " + story.getTitle() + "\n\n" + story.getFullNarrative());
        };

        ActionListener randomizeAction = e -> {
            Character p = StoryGenerator.generateRandomCharacter("Protagonist");
            protagonistName.setText(p.getName());
            protagonistRole.setText(p.getRole());
            protagonistTraits.setText(p.getTraits());
            Character s = StoryGenerator.generateRandomCharacter("Sidekick");
            sidekickName.setText(s.getName());
            sidekickRole.setText(s.getRole());
            sidekickTraits.setText(s.getTraits());
            Character v = StoryGenerator.generateRandomCharacter("Villain");
            villainName.setText(v.getName());
            villainTraits.setText(v.getTraits());
            twistField.setText(StoryGenerator.generateRandomTwist());
        };

        ActionListener saveAction = e -> {
            try {
                JFileChooser fileChooser = new JFileChooser();
                if (fileChooser.showSaveDialog(frame) == JFileChooser.APPROVE_OPTION) {
                    FileWriter writer = new FileWriter(fileChooser.getSelectedFile() + ".txt");
                    writer.write(outputArea.getText());
                    writer.close();
                    JOptionPane.showMessageDialog(frame, "Story saved!");
                }
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(frame, "Error saving story.", "Save Error", JOptionPane.ERROR_MESSAGE);
            }
        };

        ActionListener clearAction = e -> {
            protagonistName.setText("");
            protagonistRole.setText("");
            protagonistTraits.setText("");
            sidekickName.setText("");
            sidekickRole.setText("");
            sidekickTraits.setText("");
            villainName.setText("");
            villainTraits.setText("");
            genreField.setText("");
            twistField.setText("");
            toneBox.setSelectedIndex(0);
            lengthBox.setSelectedIndex(0);
            outputArea.setText("");
            protagonistBackstory.setText("");
            sidekickBackstory.setText("");
            villainBackstory.setText("");
        };

        // Attach listeners to buttons
        generateButton.addActionListener(generateAction);
        toolbarGenerate.addActionListener(generateAction);
        saveButton.addActionListener(saveAction);
        toolbarSave.addActionListener(saveAction);
        clearButton.addActionListener(clearAction);
        toolbarClear.addActionListener(clearAction);
        randomizeButton.addActionListener(randomizeAction);
        toolbarRandomize.addActionListener(randomizeAction);

        darkModeToggle.addActionListener(e -> {
            boolean dark = darkModeToggle.isSelected();
            // Update panel backgrounds
            characterPanel.setBackground(dark ? darkBgColor : bgColor);
            settingsPanel.setBackground(dark ? darkBgColor : bgColor);
            outputPanel.setBackground(dark ? darkBgColor : bgColor);
            topPanel.setBackground(dark ? new Color(0, 102, 204) : accentColor);
            headerPanel.setBackground(dark ? new Color(0, 102, 204) : accentColor);
            toolbar.setBackground(dark ? new Color(0, 102, 204) : accentColor);

            // Update component colors recursively
            updateComponentColors(characterPanel, dark);
            updateComponentColors(settingsPanel, dark);
            updateComponentColors(outputPanel, dark);
            updateComponentColors(topPanel, dark);
        });

        frame.setVisible(true);
    }

    private static JTextField createStyledField() {
        JTextField field = new JTextField();
        field.setBackground(fieldBgColor);
        field.setForeground(textColor);
        field.setFont(emojiFont);
        field.setBorder(BorderFactory.createLineBorder(accentColor, 2));
        return field;
    }

    private static void styleButton(AbstractButton button) {
        button.setBackground(accentColor);
        button.setForeground(textColor);
        button.setFont(emojiFont);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createLineBorder(accentColor, 2));
    }

    private static void styleComboBox(JComboBox<?> comboBox) {
        comboBox.setBackground(fieldBgColor);
        comboBox.setForeground(textColor);
        comboBox.setFont(emojiFont);
        comboBox.setBorder(BorderFactory.createLineBorder(accentColor, 2));
    }

    private static void addHoverEffect(JButton button) {
        button.addMouseListener(new MouseAdapter() {
            @Override 
            public void mouseEntered(MouseEvent e) {
                button.setBackground(button.getBackground().brighter());
            }

            @Override
            public void mouseExited(MouseEvent e) {
                boolean dark = darkModeToggle != null && darkModeToggle.isSelected();
                button.setBackground(dark ? darkAccentColor : accentColor);
            }
        });
    }

    private static void panelAdd(JPanel panel, GridBagConstraints gbc, Component component1, Component component2, int row) {
        gbc.gridy = row;
        gbc.gridx = 0;
        gbc.weightx = 0.5;
        panel.add(component1, gbc);
        gbc.gridx = 1;
        gbc.weightx = 0.5;
        panel.add(component2, gbc);
    }
}
 