package com.example.tfttierlist.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tfttierlist.Core.Champion;
import com.example.tfttierlist.Core.Item;
import com.example.tfttierlist.Core.SqlIO;
import com.example.tfttierlist.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private GridView champGrid;
    private SqlIO BaseDatos;
    private List<Champion> ChampionList;
    private ArrayList<HashMap<String, Object>> maplist = new ArrayList<>();

    Item Spatula = new Item("Spatula", "", "", "It must do something...", "S");
    Item Needlessly_Large_Rod = new Item("Needlessly Large Rod", "", "", "+20% Spell Damage.", "A");
    Item Tear_of_the_Goddess = new Item("Tear of the Goddess", "", "", "+20 Mana.", "A");
    Item B_F_Sword = new Item("B.F. Sword", "", "", "+15 Attack Damage.", "B");
    Item Recurve_Bow = new Item("Recurve Bow", "", "", "+15% Attack Speed.", "B");
    Item Giants_Belt = new Item("Giants Belt", "", "", "+200 Health.", "C");
    Item Negatron_Cloak = new Item("Negatron Cloak", "", "", "+25 Magic Resist.", "C");
    Item Sparring_Gloves = new Item("Sparring Gloves", "", "", "+10% Critical Strike Chance. +10% Dodge Chance.", "C");
    Item Chain_Vest = new Item("Chain Vest", "", "", "+20 Armor.", "D");
    Item Force_of_Nature = new Item("Force of Nature", "Spatula", "Spatula", "Wearers team gains +1 maximum team size.", "S");
    Item Berserker_Axe = new Item("Berserker Axe", "Spatula", "Sparring Gloves", "Wearer is also a Berserker.", "?");
    Item Blade_of_the_Ruined_King = new Item("Blade of the Ruined King", "Spatula", "Recurve Bow", "Wearer is also a Blademaster.", "?");
    Item Frozen_Mallet = new Item("Frozen Mallet", "Spatula", "Giants Belt", "Wearer is also a Glacial.", "?");
    Item Inferno_Cinder = new Item("Inferno Cinder", "Spatula", "Needlessly Large Rod", "Wearer is also an Inferno.", "?");
    Item Mages_Cap = new Item("Mages Cap", "Spatula", "Tear of the Goddess", "Wearer is also a Mage.", "?");
    Item Talisman_of_Light = new Item("Talisman of Light", "Spatula", "Negatron Cloak", "Wearer is also a Light.", "?");
    Item Wardens_Mail = new Item("Wardens Mail", "Spatula", "Chain Vest", "Wearer is also a Warden.", "?");
    Item Youmuus_Ghostblade = new Item("Youmuus Ghostblade", "Spatula", "B.F. Sword", "Wearer is also an Assassin.", "?");
    Item Guinsoo_Rageblade = new Item("Guinsoo Rageblade", "Needlessly Large Rod", "Recurve Bow", "Basic Attacks grant the wearer +4% bonus Attack Speed for the rest of combat. This effect can stack any number of times.", "S");
    Item Morellonomicon = new Item("Morellonomicon", "Needlessly Large Rod", "Giants Belt", "When the wearer deals damage with their spell, they burn the target, dealing 20% of the targets Maximum Health as true damage over 10 seconds and reducing healing by 80% for the duration of the burn. A champion can only have one burn effect at a time, preferring the strongest.", "S");
    Item Hand_of_Justice = new Item("Hand of Justice", "Tear of the Goddess", "Sparring Gloves", "At the beginning of each planning phase, the wearer gains one of the following: Basic Attacks and Spells deal +50% Damage or Basic Attacks heal 50 Health on-hit.", "S");
    Item Iceborne_Gauntlet = new Item("Iceborne Gauntlet", "Chain Vest", "Sparring Gloves", "When the wearer dodges, they create a zone of ice. Enemies inside the zone have their Attack Speed reduced by 35%.", "S");
    Item Infinity_Edge = new Item("Infinity Edge", "B.F. Sword", "Sparring Gloves", "The wearer gains +125% Critical Strike Damage.", "S");
    Item Phantom_Dancer = new Item("Phantom Dancer", "Chain Vest", "Recurve Bow", "Wearer dodges all Critical Strikes.", "S");
    Item Seraphs_Embrace = new Item("Seraphs Embrace", "Tear of the Goddess", "Tear of the Goddess", "After casting their spell, the wearer restores 20 Mana.", "S");
    Item Spear_of_Shojin = new Item("Spear of Shojin", "Tear of the Goddess", "B.F. Sword", "After casting their spell, the wearers Basic Attacks restore 18% of their Maximum Mana.", "S");
    Item Bloodthirster = new Item("Bloodthirster", "B.F. Sword", "Negatron Cloak", "Basic Attacks heal the wearer for 40% of the damage dealt.", "A");
    Item Deathblade = new Item("Deathblade", "B.F. Sword", "B.F. Sword", "Whenever the wearer kills or participates in killing an enemy, gain +15 Attack Damage for the remainder of combat. This effect can stack any number of times.", "A");
    Item Hush = new Item("Hush", "Negatron Cloak", "Tear of the Goddess", "Basic Attacks have a 33% chance to silence the target on-hit, prevent the enemy from gaining mana for 4 seconds.", "A");
    Item Ludens_Echo = new Item("Ludens Echo", "Tear of the Goddess", "Needlessly Large Rod", "When the wearer deals damage with their spell, the first target hit and up to 3 nearby enemies are dealt an additional 180 magic damage.", "A");
    Item Rabadons_Deathcap = new Item("Rabadons Deathcap", "Needlessly Large Rod", "Needlessly Large Rod", "Wearer gains +50% Spell Power Amplification. (All sources of Spell Power are 50% more effective)", "A");
    Item Runaans_Hurricane = new Item("Rabadons Deathcap", "Negatron Cloak", "Recurve Bow", "Basic Attacks fire an additional missile at another nearby enemy, dealing 60% of the wearers Attack damage and applying on-hit effects.", "A");
    Item Sword_Breaker = new Item("Sword Breaker", "Negatron Cloak", "Chain Vest", "Wearers Basic Attacks have a 33% chance to disarm the target for 3 seconds, preventing that enemy from Basic Attacking.", "A");
    Item Thiefs_Gloves = new Item("Thiefs Gloves", "Sparring Gloves", "Sparring Gloves", "At the beginning of each planning phase, the wearer equips 2 temporary items. Temporary items increase in power based on your player level.", "A");
    Item Zephyr = new Item("Zephyr", "Negatron Cloak", "Giants Belt", "When combat begins, the wearer summons a whirlwind on the opposite side of the arena that removes the closest enemy from combat for 6 seconds.", "A");
    Item Giant_Slayer = new Item("Giant Slayer", "B.F. Sword", "Recurve Bow", "The wearers basic attacks deal an additional 9% of the targets Maximum Health as true damage.", "B");
    Item Guardian_Angel = new Item("Guardian Angel", "B.F. Sword", "Chain Vest", "When the wearer dies, they cleanse negative effects and revive with up to 500 Health after a 2 second delay. This effect can trigger once per combat.", "B");
    Item Ionic_Spark = new Item("Ionic Spark", "Negatron Cloak", "Needlessly Large Rod", "Whenever an enemy casts a spell, the wearer deals 125 true damage to the caster.", "B");
    Item Jeweled_Gauntlet = new Item("Jeweled Gauntlet", "Needlessly Large Rod", "Sparring Gloves", "The wearers spells can critically strike.", "B");
    Item Red_Buff = new Item("Red Buff", "Giants Belt", "Chain Vest", "Wearers Basic Attacks burn the target on-hit, dealing 20% of the targets Maximum Health as true damage over 10 seconds and reducing healing by 80% for the duration of the burn. A champion can only have one burn effect at a time, preferring the strongest.", "B");
    Item Statikk_Shiv = new Item("Statikk Shiv", "Recurve Bow", "Tear of the Goddess", "Every third Basic Attack from the wearer deals 100 magical damage to 3 enemies.", "B");
    Item Warmogs_Armor = new Item("Warmogs Armor", "Giants Belt", "Giants Belt", "Wearer regenerates 6% of their missing Health per second.", "B");
    Item Zekes_Herald = new Item("Zekes Herald", "Giants Belt", "B.F. Sword", "When combat begins, the wearer and all allies within 2 hexes in the same row gain +15% Attack Speed for the rest of combat.", "B");
    Item Dragons_Claw = new Item("Dragons Claw", "Negatron Cloak", "Negatron Cloak", "Wearer gains 50% resistance to magic damage.", "C");
    Item Frozen_Heart = new Item("Frozen Heart", "Chain Vest", "Tear of the Goddess", "Reduce the Attack Speed of adjacent enemies by 35% for 1 second.", "C");
    Item Hextech_Gunblade = new Item("Hextech Gunblade", "B.F. Sword", "Needlessly Large Rod", "Basic Attacks and spells heal the wearer for 25% of the damage dealt.", "C");
    Item Locket_of_the_Iron_Solari = new Item("Locket of the Iron Solari", "Needlessly Large Rod", "Chain Vest", "When combat begins, the wearer and all allies within 2 hexes in the same row gain a shield that blocks 300 damage for 8 seconds.", "C");
    Item Rapid_Firecannon = new Item("Rapid Firecannon", "Recurve Bow", "Recurve Bow", "Wearer gains +100% Attack Range.", "C");
    Item Redemption = new Item("Redemption", "Giants Belt", "Tear of the Goddess", "When the wearer falls below 30% Health, nearby allies are healed for 1200 Health after a 2.5 second delay. This effect can trigger once per combat.", "C");
    Item Trap_Claw = new Item("Trap Claw", "Giants Belt", "Sparring Gloves", "At the beginning of combat, the wearer gains a shield that blocks the first enemy spell that hits them. The enemy that breaks the shield is stunned for 4 seconds.", "C");
    Item Quicksilver = new Item("Quicksilver", "Sparring Gloves", "Negatron Cloak", "The wearer gains a shield that prevents the next crowd control effect from applying. This shield refreshes after 3 seconds.", "D");
    Item Repeating_Crossbow = new Item("Repeating Crossbow", "Sparring Gloves", "Recurve Bow", "When the wearer dies, Repeating Crossbow is re-equipped to a new ally. Each time Repeating Crossbow is re-equipped, it grants additional +30% Attack Speed and +30% Critical Strike Chance for the remainder of combat. This effect can stack any number of times.", "D");
    Item Thornmail = new Item("Thornmail", "Chain Vest", "Chain Vest", "When the wearer is hit by a Basic Attack, they reflect 100% of the mitigated damage as magic damage.", "D");
    Item Titanic_Hydra = new Item("Titanic Hydra", "Recurve Bow", "Giants Belt", "Basic Attacks deal an additional 3% of the wearers Maximum Health as magic damage to the target and adjacent enemies behind them. ", "D");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ChampionList.addAll(this.BaseDatos.recuperaTodosLosCampeones());

        champGrid = (GridView) findViewById(R.id.champsGrid);
        champGrid.setOnItemClickListener(new GridView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> p1, View p2, int p3, long p4) {
                Toast.makeText(getApplicationContext(), maplist.get(p3).get("Name").toString(), Toast.LENGTH_LONG).show();
            }

        });
        for (Champion c : ChampionList) {
            String aux = c.getName().toLowerCase();
            if (aux.contains(" ")) {
                aux = aux.replace(" ", "");
            }
            String imgName = "R.drawable." + aux;
            HashMap<String, Object> mapAux = new HashMap<>();
            mapAux.put("Name", c.getName());
            mapAux.put("Img", imgName);
            maplist.add(mapAux);
        }
        GridAdapter adapter = new GridAdapter(this);
        champGrid.setAdapter(adapter);
    }

        public class GridAdapter extends BaseAdapter {
            private Context mContext;
            public GridAdapter(Context c) {
                mContext = c;
            }
            public int getCount() {
                return maplist.size();
            }
            public Object getItem(int position) {
                return null;
            }
            public long getItemId(int position) {
                return 0;
            }
            public View getView(int position, View convertView, ViewGroup parent) {
                View v = convertView;
                // Inflate the layout for each list item
                LayoutInflater _inflater = (LayoutInflater)getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                if (v == null) {
                    v = _inflater.inflate(R.layout.list_champs, null);
                }
                // Get the TextView and ImageView from CustomView for displaying item
                TextView txtview = (TextView) v.findViewById(R.id.listChampTextView);
                ImageView imgview = (ImageView) v.findViewById(R.id.listChampImageView);

                // Set the text and image for current item using data from map list
                txtview.setText(maplist.get(position).get("Name").toString());
                imgview.setImageResource(Integer.parseInt(maplist.get(position).get("Img").toString()));
                return v;
            }
        }


    }

