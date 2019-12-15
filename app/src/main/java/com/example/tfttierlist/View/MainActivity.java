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

import com.example.tfttierlist.Core.ChampClass;
import com.example.tfttierlist.Core.ChampOrigin;
import com.example.tfttierlist.Core.Champion;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Champion a = new Champion("Singed", "Poison", "Alchemist", "-", "Singed leaves a poison cloud behind him damaging enemies in the area over 4 seconds.", 'S', '5', "950 / 1710 / 3420", '0', '0', 50, 20 ,"0/0/0" ,"0/0/0" ,'0' ,"0,25" ,'0');
        Champion b = new Champion("Olaf", "Glacial", "Berserker", "-", "Olaf gains attack speed, lifesteal based on missing health, and immunity to crowd control for the rest of combat. Attack Speed Bonus: 100% / 150% / 300%. Lifesteal: 50%.", 'S', 4, "750 / 1350 / 2700", 90, 0, 35, 20 ,"60 / 107 / 214" ,"70 / 126 / 252" ,0.85 ,"25%" ,1);
        Champion c = new Champion("Nocturne", "Steel", "Assassin", "-", "Every third attack, Nocturne deals additional damage to enemies around him and heals for a portion of the damage. Heal Amount: 40% / 60% / 80%", 'S',3, "650 / 1170 / 2340", 0, 0, 25, 20, "45 / 81 / 162", "60 / 108 / 216" ,0.75 ,"25%" ,1 );
        Champion d = new Champion("Nami", "Ocean", "Mystic", "-", "Nami sends a massive wave toward a random enemy, damaging and knocking up enemies it passes through and granting allies it passes through bonus magic damage on hit. Damage: 150 / 250 / 350 Stun Duration: 1.5 / 2 / 2.5 Bonus Damage: 25 / 50 / 300", 'S', 5, "750 / 1350 / 2700", 125, 50, 25 ,20 ,"38 / 68 / 135" ,"50 / 90 / 180" ,0.75 ,"25%", 4);
        Champion e = new Champion("Lux", "x", "Avatar", "-", "Final Spark. Lux fires a straight beam of light at enemies. If at least one enemy is killed, she restores 50 mana. Damage: 600 / 900 / 9999", 'S', 7, "850 / 1530 / 3060", 80, 0, 25 ,20 ,"55 / 99 / 199" ,"65 / 117 / 234" ,0.85 ,"25%", 4);
        Champion f = new Champion("Vladimir", "Ocean", "Mage", "-", "Drain. Vladimir damages a target enemy, healing himself for the damage dealt. Damage: 200 / 325 / 450", 'C', 1, "550 / 990 / 1980", 75, 0, 35 ,20 ,"26 / 47 / 94" ,"40 / 72 / 144" ,0.65 ,"25%", 2);
        Champion g = new Champion("Amumu", "Inferno", "Warden", "-", "Curse of the Sad Mummy. Amumus rage explodes, dealing magic damage to enemies in an area around him, and stunning them for 1.5 seconds. Damage: 250 / 500 / 1337. Range: 2 / 3 / 4", 'B', 5, "900 / 1620 / 3240", 150, 50, 150 ,20 ,"41 / 74 / 149" ,"55 / 99 / 198" ,0.75 ,"25%", 1);
        Champion h = new Champion("Yasuo", "Cloud", "Blademaster", "-", "Last Breath. Yasuo blinks to the enemy with the most items and knocks them up, holding them airborn for 1 second and hitting them, dealing basic attack damage and applying on-hit effects. Hits: 4 / 5 / 6", 'B', 2, "600 / 1080 / 2160", 100, 0, 30 ,20 ,"42 / 76 / 151" ,"60 / 108 / 216" ,0.7 ,"25%", 1);
        Champion i = new Champion("Sivir", "Desert", "Blademaster", "-", "Ricochet. For the next 5 seconds, Sivirs attacks will bounce up to 10 times to nearby enemies, dealing damage and applying on-hit effects. Damage: 100% / 125% / 150%", 'B', 3, "600 / 1080 / 2160", 65, 0, 25 ,20 ,"39 / 69 / 139" ,"55 / 99 / 198" ,0.7 ,"25%", 3);
        Champion j = new Champion("Nautilus", "Ocean", "Warden", "-", "Depth Charge. Nautilus sends out a depth charge that seeks out the furthest enemy champion, knocking them up and stunning them. It also deals damage to all enemies it passes. Damage: 100 / 200 / 400. Stun Duration: 3 / 4 / 6", 'B', 3, "850 / 1530 / 3060", 125, 50, 40 ,20 ,"33 / 59 / 119" ,"55 / 99 / 198" ,0.6 ,"25%", 1);
        Champion k = new Champion("Maokai", "Woodland", "Druid", "-", "Sap Magic. After taking damage from a spell, Maokais next attack will heal him. Heal Amount: 100 / 150 / 200", 'B', 1, "650 / 1170 / 2340", 0, 0, 35 ,20 ,"28 / 50 / 99" ,"55 / 99 / 198" ,0.5 ,"25%", 1);
        Champion m = new Champion("Ashe", "Crystal", "Ranger", "-", "Rangers Focus. For 5 seconds, Ashe gains 50% Attack Speed, and her basic attacks fire a flurry of arrows dealing physical damage. Attack Speed Bonus: 50% / 75% / 250%. Damage Per Arrow: 25% / 30% / 35%", 'B', 4, "550 / 990 / 1980", 35, 0, 20 ,20 ,"48 / 86 / 173" ,"60 / 108 / 216" ,0.8 ,"25%", 4);
        Champion n = new Champion("Master Yi", "Shadow", "Blademaster", "Mystic", "Meditate. Master Yi meditates, becoming untargetable for 1 second and healing over the duration. After Master Yi finishes meditating, he gains 100% Attack Speed and deal bonus magic damage on hit for 6 seconds. Bonus Damage: 50 / 75 / 500", 'A', 5, "850 / 1530 / 3060", 150, 100, 30 ,20 ,"70 / 126 / 252" ,"70 / 126 / 252" ,1 ,"25%", 1);

        ChampOrigin aa = new ChampOrigin("Electric", "Electric champions shock nearby enemies whenever they deal or receive a critical strike. 100/300/500 dmg");
        ChampOrigin bb = new ChampOrigin("Glacial","Basic Attacks from Glacials have a chance to stun their target for 1.5 seconds. 20/35/50 Chance to Stun.");
        ChampOrigin cc = new ChampOrigin("Poison","Poison champions apply Neurotoxin when they deal damage, increasing the targets mana cost by 50%.");
        ChampOrigin dd = new ChampOrigin("Ocean","All allies restore mana every 4 seconds. 15/30/60 +Mana");
        ChampOrigin ee = new ChampOrigin("Shadow","Shadow units deal increased damage for 4 seconds at combat start, refreshed on takedown. +70% Increased Damage, Self Takedown +140% Increased Damage, Any Shadow Takedown");
        ChampOrigin ff = new ChampOrigin("Cloud","All allies gain dodge chance. +20%/+25%/+35% Dodge Chance");
        ChampOrigin gg = new ChampOrigin("Crystal","Crystal champions have a maximum amount of damage they can take from a single hit. 100/60 Max Damage");
        ChampOrigin hh = new ChampOrigin("Inferno","Inferno spell damage burns the ground beneath the target, dealing a percent of that spells pre-mitigation damage as magic damage over 4 seconds. +70% Damage & 1 Hex/+120% Damage & 3 Hexes/+180% Damage & 5 Hexes");
        ChampOrigin ii = new ChampOrigin("Light","When a Light champion dies, all other Light champions gain Attack Speed and are healed for 25% of the champions Maximum Health. +15%/+25%/+35% Attack Speed");
        ChampOrigin kk = new ChampOrigin("Steel","Steel champions gain damage immunity for a few seconds when they are reduced below 50% health. 2/3/4 Seconds of Immunity2 Seconds of Immunity");
        ChampOrigin mm = new ChampOrigin("Woodland","At the start of combat, a random Woodland champion makes a copy of themselves.");
        ChampOrigin nn = new ChampOrigin("Desert","Reduces each enemys armor.");
        ChampOrigin oo = new ChampOrigin("Mountain","At the start of combat, a random ally gains a 1500 Stoneshield.");

        ChampClass aaa = new ChampClass("Alchemist", "Innate: Alchemists ignore collision and never stop moving.");
        ChampClass bbb = new ChampClass("Avatar", "An Avatars Origin Element is counted twice for Trait bonuses.");
        ChampClass ccc = new ChampClass("Assassin", "Innate: At the start of combat, Assassins leap to the farthest enemy. Assassins gain bonus Critical Strike Damage and Chance. +75%/+150% Critical Strike Damage & +10%/+20% Critical Strike Chance");
        ChampClass ddd = new ChampClass("Mage", "Mages have a chance on cast to instead Doublecast. 50%/100% Chance");
        ChampClass eee = new ChampClass("Mystic", "All allies gain increased Magic Resistance. 40/120 Magic Resistance");
        ChampClass fff = new ChampClass("Predator", "Predators instantly kill enemies they damage who are below 25% health.");
        ChampClass ggg = new ChampClass("Berserker", "Innate: At the start of combat, Berserkers leap to the nearest enemy. Berserkers have a 40% chance to hit all units in a cone in front of them with their attacks. 40%/100% Chance & +0/+25 Attack Damage");
        ChampClass hhh = new ChampClass("Blademaster", "Blademaster Basic Attacks have a 40% chance to trigger additional attacks against their target. These additional attacks deal damage like Basic Attacks and trigger on-hit effects. 1/2/3 Extra Attack");
        ChampClass iii = new ChampClass("Ranger", "Every 3 seconds, Rangers have a chance to double their Attack Speed for 3 seconds. 35%/80%/100% Chance to x2/x2/x2.5 Attack Speed bonus");
        ChampClass jjj = new ChampClass("Soulbound", "The first Soulbound unit to die in a round will instead enter the Spirit Realm, becoming untargetable and continuing to fight as long as another Soulbound unit is alive.");
        ChampClass kkk = new ChampClass("Summoner", "Summoned units have increased health and duration. +30%/+120% increase");
        ChampClass mmm = new ChampClass("Warden", "Wardens gain increased total Armor. +150%/+300%/+450% Armor");
        ChampClass nnn = new ChampClass("Druid", "Druids regenerate 40 health each second.");


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

