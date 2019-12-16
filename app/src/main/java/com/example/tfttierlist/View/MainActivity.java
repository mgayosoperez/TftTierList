package com.example.tfttierlist.View;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tfttierlist.Core.ChampClass;
import com.example.tfttierlist.Core.ChampOrigin;
import com.example.tfttierlist.Core.Champion;
import com.example.tfttierlist.Core.Item;
import com.example.tfttierlist.Core.SqlIO;
import com.example.tfttierlist.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private GridView champGrid;
    private ArrayList<HashMap<String, Object>> maplist = new ArrayList<>();
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



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Champion a = new Champion("Singed", "Poison", "Alchemist", "-", "Singed leaves a poison cloud behind him damaging enemies in the area over 4 seconds.", 'S', '5', "950 / 1710 / 3420", '0', '0', 50, 20 ,"0/0/0" ,"0/0/0" ,'0' ,"0,25" ,'0');
        Champion b = new Champion("Olaf", "Glacial", "Berserker", "-", "Olaf gains attack speed, lifesteal based on missing health, and immunity to crowd control for the rest of combat. Attack Speed Bonus: 100% / 150% / 300%. Lifesteal: 50%.", 'S', 4, "750 / 1350 / 2700", 90, 0, 35, 20 ,"60 / 107 / 214" ,"70 / 126 / 252" ,0.85 ,"25%" ,1);
        Champion c = new Champion("Nocturne", "Steel", "Assassin", "-", "Every third attack, Nocturne deals additional damage to enemies around him and heals for a portion of the damage. Heal Amount: 40% / 60% / 80%", 'S',3, "650 / 1170 / 2340", 0, 0, 25, 20, "45 / 81 / 162", "60 / 108 / 216" ,0.75 ,"25%" ,1 );
        Champion d = new Champion("Nami", "Ocean", "Mystic", "-", "Nami sends a massive wave toward a random enemy, damaging and knocking up enemies it passes through and granting allies it passes through bonus magic damage on hit. Damage: 150 / 250 / 350 Stun Duration: 1.5 / 2 / 2.5 Bonus Damage: 25 / 50 / 300", 'S', 5, "750 / 1350 / 2700", 125, 50, 25 ,20 ,"38 / 68 / 135" ,"50 / 90 / 180" ,0.75 ,"25%", 4);
        Champion e = new Champion("Zed", "Eléctrico", "Asesino", "Invocador", "-", 'S', 5, "850/1530/3060", 150, 0, 30, 20 ,"80/144/288" ,"80/144/288" ,1 ,"25%" ,1);
        Champion f = new Champion("Vladimir", "Ocean", "Mage", "-", "Drain. Vladimir damages a target enemy, healing himself for the damage dealt. Damage: 200 / 325 / 450", 'C', 1, "550 / 990 / 1980", 75, 0, 35 ,20 ,"26 / 47 / 94" ,"40 / 72 / 144" ,0.65 ,"25%", 2);
        Champion g = new Champion("Annie", "Inferno", "Summoner", "-", "Summon Tibbers. Annie summons Tibbers to fight alongside her dealing damage to enemies in the area. Initial Damage: 100 / 200 / 300. Tibbers Damage: 150 / 300 / 1000. Tibbers Health: 2000. Tibbers Armor: 30", 'S', 4, "700 / 1260 / 2520", 75, 0, 20 ,20 ,"31 / 57 / 113" ,"45 / 81 / 162" ,0.7 ,"25%", 3);
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



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        champGrid = (GridView) findViewById(R.id.champsGrid);
        champGrid.setOnItemClickListener(new GridView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
            HashMap<String, Object> item1 = new HashMap<>();
            item1.put("Name", "Ashe");
            item1.put("Img", R.drawable.ashe);
            maplist.add(item1);

            HashMap<String, Object> item2 = new HashMap<>();
            item2.put("Name", "Annie");
            item2.put("Img", R.drawable.annie);
            maplist.add(item2);

            HashMap<String, Object> item3 = new HashMap<>();
            item3.put("Name", "Master Yi");
            item3.put("Img", R.drawable.masteryi);

            maplist.add(item3);
            HashMap<String, Object> item4 = new HashMap<>();
            item4.put("Name", "Dr Mundo");
            item4.put("Img", R.drawable.drmundo);

            maplist.add(item4);
            HashMap<String, Object> item5 = new HashMap<>();
            item5.put("Name", "Master Yi");
            item5.put("Img", R.drawable.masteryi);
            maplist.add(item5);

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
    public  void alfabetico(){
        maplist.clear();
        HashMap<String, Object> item1 = new HashMap<>();
        item1.put("Name", "Ashe");
        item1.put("Img", R.drawable.ashe);
        maplist.add(item1);
        HashMap<String, Object> item2 = new HashMap<>();
        item2.put("Name", "Annie");
        item2.put("Img", R.drawable.annie);
        maplist.add(item2);
        HashMap<String, Object> item3 = new HashMap<>();
        item3.put("Name", "Master Yi");
        item3.put("Img", R.drawable.masteryi);
        maplist.add(item3);
        HashMap<String, Object> item12 = new HashMap<>();
        item12.put("Name", "Maokai");
        item12.put("Img", R.drawable.maokai);
        maplist.add(item12);
        HashMap<String, Object> item4 = new HashMap<>();
        item4.put("Name", "Nami");
        item4.put("Img", R.drawable.nami);
        maplist.add(item4);
        HashMap<String, Object> item5 = new HashMap<>();
        item5.put("Name", "Nautilus");
        item5.put("Img", R.drawable.nautilus);
        maplist.add(item5);
        HashMap<String, Object> item6 = new HashMap<>();
        item6.put("Name", "Nocturne");
        item6.put("Img", R.drawable.nocturne);
        maplist.add(item6);
        HashMap<String, Object> item7 = new HashMap<>();
        item7.put("Name", "Olaf");
        item7.put("Img", R.drawable.olaf);
        maplist.add(item7);
        HashMap<String, Object> item8 = new HashMap<>();
        item8.put("Name", "Singed");
        item8.put("Img", R.drawable.singed);
        maplist.add(item8);
        HashMap<String, Object> item9 = new HashMap<>();
        item9.put("Name", "Sivir");
        item9.put("Img", R.drawable.sivir);
        maplist.add(item9);
        HashMap<String, Object> item10 = new HashMap<>();
        item10.put("Name", "Vladimir");
        item10.put("Img", R.drawable.vladimir);
        maplist.add(item10);
        HashMap<String, Object> item11 = new HashMap<>();
        item11.put("Name", "Yasuo");
        item11.put("Img", R.drawable.yasuo);
        maplist.add(item11);
        HashMap<String, Object> item13 = new HashMap<>();
        item13.put("Name", "Zed");
        item13.put("Img", R.drawable.zed);
        maplist.add(item13);
    }
    public void tier(){
        maplist.clear();
        HashMap<String, Object> item1 = new HashMap<>();
        item1.put("Name", "Ashe");
        item1.put("Img", R.drawable.ashe);
        HashMap<String, Object> item2 = new HashMap<>();
        item2.put("Name", "Annie");
        item2.put("Img", R.drawable.annie);
        HashMap<String, Object> item3 = new HashMap<>();
        item3.put("Name", "Master Yi");
        item3.put("Img", R.drawable.masteryi);
        HashMap<String, Object> item12 = new HashMap<>();
        item12.put("Name", "Maokai");
        item12.put("Img", R.drawable.maokai);
        HashMap<String, Object> item4 = new HashMap<>();
        item4.put("Name", "Nami");
        item4.put("Img", R.drawable.nami);
        HashMap<String, Object> item5 = new HashMap<>();
        item5.put("Name", "Nautilus");
        item5.put("Img", R.drawable.nautilus);
        HashMap<String, Object> item6 = new HashMap<>();
        item6.put("Name", "Nocturne");
        item6.put("Img", R.drawable.nocturne);
        HashMap<String, Object> item7 = new HashMap<>();
        item7.put("Name", "Olaf");
        item7.put("Img", R.drawable.olaf);
        HashMap<String, Object> item8 = new HashMap<>();
        item8.put("Name", "Singed");
        item8.put("Img", R.drawable.singed);
        HashMap<String, Object> item9 = new HashMap<>();
        item9.put("Name", "Sivir");
        item9.put("Img", R.drawable.sivir);
        HashMap<String, Object> item10 = new HashMap<>();
        item10.put("Name", "Vladimir");
        item10.put("Img", R.drawable.vladimir);
        HashMap<String, Object> item11 = new HashMap<>();
        item11.put("Name", "Yasuo");
        item11.put("Img", R.drawable.yasuo);
        HashMap<String, Object> item13 = new HashMap<>();
        item13.put("Name", "Zed");
        item13.put("Img", R.drawable.zed);
        maplist.add(item2);
        maplist.add(item4);
        maplist.add(item6);
        maplist.add(item7);
        maplist.add(item8);
        maplist.add(item13);
        maplist.add(item3);
        maplist.add(item1);
        maplist.add(item12);
        maplist.add(item5);
        maplist.add(item11);
        maplist.add(item9);
        maplist.add(item10);
    }
    public  void coste(){
        maplist.clear();
        HashMap<String, Object> item1 = new HashMap<>();
        item1.put("Name", "Ashe");
        item1.put("Img", R.drawable.ashe);
        HashMap<String, Object> item2 = new HashMap<>();
        item2.put("Name", "Annie");
        item2.put("Img", R.drawable.annie);
        HashMap<String, Object> item3 = new HashMap<>();
        item3.put("Name", "Master Yi");
        item3.put("Img", R.drawable.masteryi);
        HashMap<String, Object> item12 = new HashMap<>();
        item12.put("Name", "Maokai");
        item12.put("Img", R.drawable.maokai);
        HashMap<String, Object> item4 = new HashMap<>();
        item4.put("Name", "Nami");
        item4.put("Img", R.drawable.nami);
        HashMap<String, Object> item5 = new HashMap<>();
        item5.put("Name", "Nautilus");
        item5.put("Img", R.drawable.nautilus);
        HashMap<String, Object> item6 = new HashMap<>();
        item6.put("Name", "Nocturne");
        item6.put("Img", R.drawable.nocturne);
        HashMap<String, Object> item7 = new HashMap<>();
        item7.put("Name", "Olaf");
        item7.put("Img", R.drawable.olaf);
        HashMap<String, Object> item8 = new HashMap<>();
        item8.put("Name", "Singed");
        item8.put("Img", R.drawable.singed);
        HashMap<String, Object> item9 = new HashMap<>();
        item9.put("Name", "Sivir");
        item9.put("Img", R.drawable.sivir);
        HashMap<String, Object> item10 = new HashMap<>();
        item10.put("Name", "Vladimir");
        item10.put("Img", R.drawable.vladimir);
        HashMap<String, Object> item11 = new HashMap<>();
        item11.put("Name", "Yasuo");
        item11.put("Img", R.drawable.yasuo);
        HashMap<String, Object> item13 = new HashMap<>();
        item13.put("Name", "Zed");
        item13.put("Img", R.drawable.zed);
        maplist.add(item3);
        maplist.add(item5);
        maplist.add(item8);
        maplist.add(item13);
        maplist.add(item1);
        maplist.add(item2);
        maplist.add(item7);
        maplist.add(item5);
        maplist.add(item6);
        maplist.add(item9);
        maplist.add(item11);
        maplist.add(item12);
        maplist.add(item10);
    }

    }



