package com.example.tfttierlist.Core;

import android.content.Context;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;


public class SqlIO extends SQLiteOpenHelper {
    private static String LOG_TAG = SqlIO.class.getSimpleName();
    private static final String DATABASE_NAME = "Tft Tier List";
    private static final int DATABASE_VERSION = 1;

    public SqlIO(Context context)
    {
        super( context, DATABASE_NAME, null, DATABASE_VERSION );
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.beginTransaction();

        try {
            db.execSQL( "CREATE TABLE IF NOT EXISTS item("
                    + "nombre varchar(15) PRIMARY KEY,"
                    + "objeto1 varchar(15),"
                    + "objeto2 varchar(15),"
                    + "descripcion varchar(500) NOT NULL,"
                    + "tier char,"
                    + "imagen varchar(80)"
                    +")"  );

            db.execSQL( "CREATE TABLE IF NOT EXISTS campeon("
                    + "nombre varchar(15) PRIMARY KEY,"
                    + "origen varchar(15) NOT NULL,"
                    + "clase varchar(15) NOT NULL,"
                    + "claseOrigen varchar(15),"
                    + "descripcion varchar(500) NOT NULL,"
                    + "tier varchar NOT NULL,"
                    + "vida varchar(5) NOT NULL,"
                    + "coste varchar(1) NOT NULL,"
                    + "mana varchar(5) NOT NULL,"
                    + "manaInicial varchar(5) NOT NULL,"
                    + "armadura varchar(5) NOT NULL,"
                    + "mr varchar(5) NOT NULL,"
                    + "dps varchar(5) NOT NULL,"
                    + "daño varchar(5) NOT NULL,"
                    + "vAtaque varchar(15) NOT NULL,"
                    + "critico varchar(5) NOT NULL,"
                    + "alcance varchar(5) NOT NULL"
                    +")"  );

            db.execSQL( "CREATE TABLE IF NOT EXISTS clase("
                    + "nombre varchar(15) PRIMARY KEY,"
                    + "descripcion varchar(500) NOT NULL,"
                    + "imagen varchar(80)"
                    +")"  );

            db.execSQL( "CREATE TABLE IF NOT EXISTS origin("
                    + "nombre varchar(15) PRIMARY KEY,"
                    + "descripcion varchar(500) NOT NULL,"
                    + "imagen varchar(80)"
                    +")"  );

            final String datosClase ="INSERT INTO `CLASE`(`nombre`, `descripcion`, `imagen`)" +
                    " VALUES  ('Alchemist', 'Innate: Alchemists ignore collision and never stop moving.', '-')," +
                    "('Avatar', 'An Avatars Origin Element is counted twice for Trait bonuses.', '-')," +
                    "('Assassin', 'Innate: At the start of combat, Assassins leap to the farthest enemy. Assassins gain bonus Critical Strike Damage and Chance. +75%/+150% Critical Strike Damage & +10%/+20% Critical Strike Chance', '-')," +
                    "('Mage', 'Mages have a chance on cast to instead Doublecast. 50%/100% Chance', '-')," +
                    "('Mystic', 'All allies gain increased Magic Resistance. 40/120 Magic Resistance', '-')," +
                    "('Predator', 'Predators instantly kill enemies they damage who are below 25% health.', '-')," +
                    "('Berserker', 'Innate: At the start of combat, Berserkers leap to the nearest enemy. Berserkers have a 40% chance to hit all units in a cone in front of them with their attacks. 40%/100% Chance & +0/+25 Attack Damage', '-')," +
                    "('Blademaster', 'Blademaster Basic Attacks have a 40% chance to trigger additional attacks against their target. These additional attacks deal damage like Basic Attacks and trigger on-hit effects. 1/2/3 Extra Attack', '-')," +
                    "('Ranger', 'Every 3 seconds, Rangers have a chance to double their Attack Speed for 3 seconds. 35%/80%/100% Chance to x2/x2/x2.5 Attack Speed bonus', '-')," +
                    "('Soulbound', 'The first Soulbound unit to die in a round will instead enter the Spirit Realm, becoming untargetable and continuing to fight as long as another Soulbound unit is alive.', '-')," +
                    "('Summoner', 'Summoned units have increased health and duration. +30%/+120% increase', '-')," +
                    "('Warden', 'Wardens gain increased total Armor. +150%/+300%/+450% Armor', '-')," +
                    "('Druid', 'Druids regenerate 40 health each second.', '-');";
            db.execSQL(datosClase);

            final String datosOrigen ="INSERT INTO `ORIGEN` (`nombre`, `descripcion`, `imagen`) VALUES ('Electric', 'Electric champions shock nearby enemies whenever they deal or receive a critical strike. 100/300/500 dmg', '-')," +
                    "('Glacial','Basic Attacks from Glacials have a chance to stun their target for 1.5 seconds. 20/35/50 Chance to Stun.','-')," +
                    "('Poison','Poison champions apply Neurotoxin when they deal damage, increasing the targets mana cost by 50%.','-')," +
                    "('Ocean','All allies restore mana every 4 seconds. 15/30/60 +Mana','-')," +
                    "('Shadow','Shadow units deal increased damage for 4 seconds at combat start, refreshed on takedown. +70% Increased Damage, Self Takedown +140% Increased Damage, Any Shadow Takedown','-')," +
                    "('Cloud','All allies gain dodge chance. +20%/+25%/+35% Dodge Chance','-')," +
                    "('Crystal','Crystal champions have a maximum amount of damage they can take from a single hit. 100/60 Max Damage','-')," +
                    "('Inferno','Inferno spell damage burns the ground beneath the target, dealing a percent of that spells pre-mitigation damage as magic damage over 4 seconds. +70% Damage & 1 Hex/+120% Damage & 3 Hexes/+180% Damage & 5 Hexes','-')," +
                    "('Light','When a Light champion dies, all other Light champions gain Attack Speed and are healed for 25% of the champions Maximum Health. +15%/+25%/+35% Attack Speed','-')," +
                    "('Steel','Steel champions gain damage immunity for a few seconds when they are reduced below 50% health. 2/3/4 Seconds of Immunity2 Seconds of Immunity','')," +
                    "('Woodland','At the start of combat, a random Woodland champion makes a copy of themselves.','')," +
                    "('Desert','Reduces each enemys armor.','')," +
                    "('Mountain','At the start of combat, a random ally gains a 1500 Stoneshield.','');";
            db.execSQL(datosOrigen);

            final String datosItem ="INSERT INTO `ITEM` (`nombre`, `objeto1`, `objeto2`, `descripcion`, `tier`, `imagen`) VALUES ('Spatula', '', '', 'It must do something...', 'S', '-')," +
                    "('Needlessly Large Rod', '', '', '+20% Spell Damage.', 'A', '-')," +
                    "('Tear of the Goddess','','','+20 Mana.','A','-')," +
                    "('B.F. Sword','','','+15 Attack Damage.','B','-')," +
                    "('Recurve Bow','','','+15% Attack Speed','B','-')," +
                    "('Giants Belt','','','+200 Health.','C','-')," +
                    "('Negatron Cloak','','','+25 Magic Resist.','C','-')," +
                    "('Sparring Gloves','','','+10% Critical Strike Chance. +10% Dodge Chance','C','-')," +
                    "('Chain Vest','','','+20 Armor.','D','-')," +
                    "('Force of Nature','Spatula','Spatula','Wearers team gains +1 maximum team size.','S','-')," +
                    "('Berserker Axe','Spatula','Sparring Gloves','Wearer is also a Berserker.','?','-')," +
                    "('Blade of the Ruined King','Spatula','Recurve Bow','Wearer is also a Blademaster.','?','-')," +
                    "('Frozen Mallet','Spatula','Giants Belt','Wearer is also a Glacial.','?','-')," +
                    "('Inferno Cinder','Spatula','Needlessly Large Rod','Wearer is also an Inferno.','?','-')," +
                    "('Mages Cap','Spatula','Tear of the Goddess','Wearer is also a Mage.','?','-')," +
                    "('Talisman of Light','Spatula','Negatron Cloak','Wearer is also a Light.','?','-')," +
                    "('Wardens Mail','Spatula','Chain Vest','Wearer is also a Warden.','?','-')," +
                    "('Youmuus Ghostblade','Spatula','B.F. Sword','Wearer is also an Assassin.','?','-')," +
                    "('Guinsoo Rageblade','Needlessly Large Rod','Recurve Bow','Basic Attacks grant the wearer +4% bonus Attack Speed for the rest of combat. This effect can stack any number of times.','S','-')," +
                    "('Morellonomicon','Needlessly Large Rod','Giants Belt','When the wearer deals damage with their spell, they burn the target, dealing 20% of the targets Maximum Health as true damage over 10 seconds and reducing healing by 80% for the duration of the burn. A champion can only have one burn effect at a time, preferring the strongest.','S','-')," +
                    "('Hand of Justice','Tear of the Goddess','Sparring Gloves','At the beginning of each planning phase, the wearer gains one of the following: Basic Attacks and Spells deal +50% Damage or Basic Attacks heal 50 Health on-hit.','S','-')," +
                    "('Iceborne Gauntlet','Chain Vest','Sparring Gloves','When the wearer dodges, they create a zone of ice. Enemies inside the zone have their Attack Speed reduced by 35%.','S','-')," +
                    "('Infinity Edge','B.F. Sword','Sparring Gloves','The wearer gains +125% Critical Strike Damage.','S','-')," +
                    "('Phantom Dancer','Chain Vest','Recurve Bow','Wearer dodges all Critical Strikes.','S','-')," +
                    "('Seraphs Embrace','Tear of the Goddess','Tear of the Goddess','After casting their spell, the wearer restores 20 Mana.','S','-')," +
                    "('Spear of Shojin','Tear of the Goddess','B.F. Sword','After casting their spell, the wearers Basic Attacks restore 18% of their Maximum Mana.','S','-')," +
                    "('Bloodthirster','B.F. Sword','Negatron Cloak','Basic Attacks heal the wearer for 40% of the damage dealt.','A','-')," +
                    "('Deathblade','B.F. Sword','B.F. Sword','Whenever the wearer kills or participates in killing an enemy, gain +15 Attack Damage for the remainder of combat. This effect can stack any number of times.','A','-')," +
                    "('Hush','Negatron Cloak','Tear of the Goddess','Basic Attacks have a 33% chance to silence the target on-hit, prevent the enemy from gaining mana for 4 seconds.','A','-')," +
                    "('Ludens Echo','Tear of the Goddess','Needlessly Large Rod','When the wearer deals damage with their spell, the first target hit and up to 3 nearby enemies are dealt an additional 180 magic damage.','A','-')," +
                    "('Rabadons Deathcap','Needlessly Large Rod','Needlessly Large Rod','Wearer gains +50% Spell Power Amplification. (All sources of Spell Power are 50% more effective)','A','-')," +
                    "('Runaans Hurricane','Negatron Cloak','Recurve Bow','Basic Attacks fire an additional missile at another nearby enemy, dealing 60% of the wearers Attack damage and applying on-hit effects.','A','-')," +
                    "('Sword Breaker','Negatron Cloak','Chain Vest','Wearers Basic Attacks have a 33% chance to disarm the target for 3 seconds, preventing that enemy from Basic Attacking.','A','-')," +
                    "('Thiefs Gloves','Sparring Gloves','Sparring Gloves','At the beginning of each planning phase, the wearer equips 2 temporary items. Temporary items increase in power based on your player level.','A','-')," +
                    "('Zephyr','Negatron Cloak','Giants Belt','When combat begins, the wearer summons a whirlwind on the opposite side of the arena that removes the closest enemy from combat for 6 seconds.','A','-')," +
                    "('Giant Slayer','B.F. Sword','Recurve Bow','The wearers basic attacks deal an additional 9% of the targets Maximum Health as true damage.','B','-')," +
                    "('Guardian Angel','B.F. Sword','Chain Vest','When the wearer dies, they cleanse negative effects and revive with up to 500 Health after a 2 second delay. This effect can trigger once per combat.','B','-')," +
                    "('Ionic Spark','Negatron Cloak','Needlessly Large Rod','Whenever an enemy casts a spell, the wearer deals 125 true damage to the caster.','B','-')," +
                    "('Jeweled Gauntlet','Needlessly Large Rod','Sparring Gloves','The wearers spells can critically strike.','B','-')," +
                    "('Red Buff','Giants Belt','Chain Vest','Wearers Basic Attacks burn the target on-hit, dealing 20% of the targets Maximum Health as true damage over 10 seconds and reducing healing by 80% for the duration of the burn. A champion can only have one burn effect at a time, preferring the strongest.','B','-')," +
                    "('Statikk Shiv','Recurve Bow','Tear of the Goddess','Every third Basic Attack from the wearer deals 100 magical damage to 3 enemies.','B','-')," +
                    "('Warmogs Armor','Giants Belt','Giants Belt','Wearer regenerates 6% of their missing Health per second.','B','-')," +
                    "('Zekes Herald','Giants Belt','B.F. Sword','When combat begins, the wearer and all allies within 2 hexes in the same row gain +15% Attack Speed for the rest of combat.','B','-')," +
                    "('Dragons Claw','Negatron Cloak','Negatron Cloak','Wearer gains 50% resistance to magic damage.','C','-')," +
                    "('Frozen Heart','Chain Vest','Tear of the Goddess','Reduce the Attack Speed of adjacent enemies by 35% for 1 second.','C','-')," +
                    "('Hextech Gunblade','B.F. Sword','Needlessly Large Rod','Basic Attacks and spells heal the wearer for 25% of the damage dealt.','C','-')," +
                    "('Locket of the Iron Solari','Needlessly Large Rod','Chain Vest','When combat begins, the wearer and all allies within 2 hexes in the same row gain a shield that blocks 300 damage for 8 seconds.','C','-')," +
                    "('Rapid Firecannon','Recurve Bow','Recurve Bow','Wearer gains +100% Attack Range.','C','-')," +
                    "('Redemption','Giants Belt','Tear of the Goddess','When the wearer falls below 30% Health, nearby allies are healed for 1200 Health after a 2.5 second delay. This effect can trigger once per combat.','C','-')," +
                    "('Trap Claw','Giants Belt','Sparring Gloves','At the beginning of combat, the wearer gains a shield that blocks the first enemy spell that hits them. The enemy that breaks the shield is stunned for 4 seconds.','C','-')," +
                    "('Quicksilver','Sparring Gloves','Negatron Cloak','The wearer gains a shield that prevents the next crowd control effect from applying. This shield refreshes after 3 seconds','D','-')," +
                    "('Repeating Crossbow','Sparring Gloves','Recurve Bow','When the wearer dies, Repeating Crossbow is re-equipped to a new ally. Each time Repeating Crossbow is re-equipped, it grants additional +30% Attack Speed and +30% Critical Strike Chance for the remainder of combat. This effect can stack any number of times.','D','-')," +
                    "('Thornmail','Chain Vest','Chain Vest','When the wearer is hit by a Basic Attack, they reflect 100% of the mitigated damage as magic damage.','D','-')," +
                    "('Titanic Hydra','Recurve Bow','Giants Belt','Basic Attacks deal an additional 3% of the wearers Maximum Health as magic damage to the target and adjacent enemies behind them.','D','-');";

            db.execSQL(datosItem);

            final String datosCampeon ="INSERT INTO `CAMPEON` (`nombre`, `origen`, `clase`, `claseOrigen`, `descripcion`, `tier`, `coste`, `vida`, `mana`,`manaInicial`, `armadura`, `mr`, `dps`, `daño`, `vAtaque`, `critico`, `alcance`) VALUES" +
                    "                      ('Zed', 'Eléctrico', 'Asesino', 'Invocador', '-', 'S', '-', '5', '850/1530/3060', '150', '0', '30', '20' ,'80/144/288' ,'80/144/288' ,'1' ,'25%' ,'1')," +
                    "('Singed', 'Poison', 'Alchemist', '-', 'Singed leaves a poison cloud behind him damaging enemies in the area over 4 seconds.', 'S', '5', '950 / 1710 / 3420', '0', '0', '50', '20' ,'0/0/0' ,'0/0/0' ,'0' ,'25%' ,'0')," +
                    "('Olaf', 'Glacial', 'Berserker', '-', 'Olaf gains attack speed, lifesteal based on missing health, and immunity to crowd control for the rest of combat. Attack Speed Bonus: 100% / 150% / 300%. Lifesteal: 50%.', 'S', '4', '750 / 1350 / 2700', '90', '0', '35', '20' ,'60 / 107 / 214' ,'70 / 126 / 252' ,'0.85' ,'25%' ,'1')," +
                    "('Nocturne', 'Steel', 'Assassin', '-', 'Every third attack, Nocturne deals additional damage to enemies around him and heals for a portion of the damage. Heal Amount: 40% / 60% / 80%', 'S','3', '650 / 1170 / 2340', '0', '0', '25', '20', '45 / 81 / 162', '60 / 108 / 216' ,'0.75' ,'25%' ,'1' )," +
                    "('Nami', 'Ocean', 'Mystic', '-', 'Nami sends a massive wave toward a random enemy, damaging and knocking up enemies it passes through and granting allies it passes through bonus magic damage on hit. Damage: 150 / 250 / 350 Stun Duration: 1.5 / 2 / 2.5 Bonus Damage: 25 / 50 / 300', 'S', '5', '750 / 1350 / 2700', '125', '50', '25' ,'20' ,'38 / 68 / 135' ,'50 / 90 / 180' ,'0.75' ,'25%', '4')," +
                    "('Lux', 'x', 'Avatar', '-', 'Final Spark. Lux fires a straight beam of light at enemies. If at least one enemy is killed, she restores 50 mana. Damage: 600 / 900 / 9999', 'S', '7', '850 / 1530 / 3060', '80', '0', '25' ,'20' ,'55 / 99 / 199' ,'65 / 117 / 234' ,'0.85' ,'25%', '4')," +
                    "('Khazix', 'Desert', 'Assassin', '-', 'Void Assault. KhaZix goes stealth and attacks the enemy with the lowest health after a short delay. This attack is a critical hit and restores mana. Bonus Damage: 100 / 200 / 500. Mana Refund: 5 / 10 / 15', 'S', '4', '750 / 1350 / 2700', '40', '0', '25' ,'20' ,'60 / 108 / 216' ,'75 / 135 / 270' ,'0.8' ,'25%', '1')," +
                    "('Annie', 'Inferno', 'Summoner', '-', 'Summon Tibbers. Annie summons Tibbers to fight alongside her dealing damage to enemies in the area. Initial Damage: 100 / 200 / 300. Tibbers Damage: 150 / 300 / 1000. Tibbers Health: 2000. Tibbers Armor: 30', 'S', '4', '700 / 1260 / 2520', '75', '0', '20' ,'20' ,'31 / 57 / 113' ,'45 / 81 / 162' ,'0.7' ,'25%', '3')," +
                    "('Brand', 'Inferno', 'Mage', '-', 'Pyroclasm. Brand launches a bouncing fireball, damaging enemies hit. Damage: 225 / 300 / 600. Bounces: 5 / 7 / 20.', 'A', '4', '700 / 1260 / 2520', '90', '0', '25' ,'20' ,'39 / 69 / 139' ,'55 / 99 / 198' ,'0.7' ,'25%', '3')," +
                    "('Janna', 'Cloud', 'Mystic', '-', 'Monsoon. Janna channels winds which heal allies based on their maximum health and stun nearby enemies for 1 second. Heal Amount: 20% / 30% / 100%', 'A', '4', '600 / 1080 / 2160', '125', '50', '20' ,'20' ,'31 / 57 / 113' ,'45 / 81 / 162' ,'0.7' ,'25%', '3')," +
                    "('Kindred', 'Inferno', 'Shadow', 'Ranger', 'Dance of Dread. Wolf mauls Kindreds target, dealing magic damage and reducing healing by 80% to her target for 5 seconds, while Lamb leaps away from Kindreds target. Damage: 150 / 325 / 650', 'A', '3', '650 / 1170 / 2340', '35', '0', '20' ,'20' ,'41 / 74 / 149' ,'55 / 99 / 198' ,'0.75' ,'25%', '3')," +
                    "('Malphite', 'Mountain', 'Warden', '-', 'Unstoppable Force. Malphite charges toward a random enemy, dealing damage and knocking all nearby enemies into the air and stunning them.. Damage: 150 / 300 / 1000. Stun Duration: 2 / 2.5 / 5', 'A', '4', '850 / 1530 / 3060', '150', '50', '50' ,'20' ,'33 / 59 / 119' ,'60 / 108 / 216' ,'0.55' ,'25%', '1')," +
                    "('Master Yi', 'Shadow', 'Blademaster', 'Mystic', 'Meditate. Master Yi meditates, becoming untargetable for 1 second and healing over the duration. After Master Yi finishes meditating, he gains 100% Attack Speed and deal bonus magic damage on hit for 6 seconds. Bonus Damage: 50 / 75 / 500', 'A', '5', '850 / 1530 / 3060', '150', '100', '30' ,'20' ,'70 / 126 / 252' ,'70 / 126 / 252' ,'1' ,'25%', '1')," +
                    "('Qiyana', 'x', 'Assassin', '-', 'Edge of Ixtal. Qiyana dashes to the side of her target and throws a blast of wind through them, damaging and stunning enemies it passes through. Qiyanas element will change every match between Woodland, Inferno, Ocean, and Cloud. Damage: 300 / 500 / 700. Stun Duration: 3 / 4 / 5', 'A', '3', '650 / 1170 / 2340', '100', '50', '25' ,'20' ,'46 / 82 / 164' ,'65 / 117 / 234' ,'0.7' ,'25%', '1')," +
                    "('Taric', 'Crystal', 'Warden', '-', 'Cosmic Radiance. After a delay, Taric and all nearby allies become invulnerable. Duration: 3 / 3 / 5. Range: 2 / 3 / 4', 'A', '5', '900 / 1620 / 3240', '125', '50', '60' ,'20' ,'39 / 70 / 140' ,'60 / 108 / 216' ,'0.65' ,'25%', '1')," +
                    "('Volibear', 'Electric', 'Glacial', 'Berserker', 'Frenzied Bite. Volibear bites an enemy. If the target has less than 35% health, it is killed instantly and Volibear fully restores his mana. Damage: 200 / 450 / 850', 'A', '2', '850 / 1530 / 3060', '75', '0', '35', '20' ,'42 / 76 / 151' ,'60 / 108 / 216' ,'0.7' ,'25%' , '1')," +
                    "('Yorick', 'Light', 'Summoner', '-', 'Shepherd of Souls. Yorick blesses his allies with the lowest health, not including Light Walkers. When they die, they resurect as Light Walkers and benefits from the effects of the Light origin. Number of Allies: 2 / 3 / 12. Light Walker Health: 600 / 1000 / 2000. Light Walker Damage: 100 / 200 / 300. Light Walker Armor: 20', 'A', '4', '800 / 1440 / 2880', '75', '0', '35', '20' ,'46 / 82 / 164' ,'65 / 117 / 234' ,'0.7' ,'25%' , '1')," +
                    "('Senna', 'Shadow', 'Soulbound', '-', 'Piercing Darkness. Senna fires a beam through her furthest ally, dealing magic damage to enemies, and buffing allies on-hits for 5 seconds to deal bonus magic damage from Senna. Damage: 50 / 100 / 150. Bonus Damage: 25 / 45 / 75', 'A', '2', '450 / 810 / 1620', '75', '50', '25' ,'20' ,'31 / 57 / 113' ,'45 / 81 / 162' ,'0.7' ,'25%', '4')," +
                    "('Lucian', 'Light', 'Soulbound', '-', 'The Culling. Lucian fires at 4 times his normal Attacks Per Second in a direction for 4 seconds, each attacking for a percentage of his AD, applying on-hits, and dealing magic damage. Lucian will dash during the Culling to keep hitting enemies. Percentage of AD: 25% / 30% / 50%. Damage: 40 / 50 / 100', 'A', '4', '450 / 810 / 1620', '75', '50', '25' ,'20' ,'52 / 94 / 187' ,'65 / 117 / 234' ,'0.8' ,'25%', '3')," +
                    "('Ashe', 'Crystal', 'Ranger', '-', 'Rangers Focus. For 5 seconds, Ashe gains 50% Attack Speed, and her basic attacks fire a flurry of arrows dealing physical damage. Attack Speed Bonus: 50% / 75% / 250%. Damage Per Arrow: 25% / 30% / 35%', 'B', '4', '550 / 990 / 1980', '35', '0', '20' ,'20' ,'48 / 86 / 173' ,'60 / 108 / 216' ,'0.8' ,'25%', '4')," +
                    "('Dr Mundo', 'Poison', 'Berserker', '-', 'Adrenaline Rush. Dr Mundo creates a toxic cloud around him that deals damage to nearby enemies and heals for a portion of the damage every second for 8 seconds. Damage: 50 / 100 / 150. Heal Amount: 100% / 125% / 150%', 'B', '3', '750 / 1350 / 2700', '125', '75', '35' ,'20' ,'36 / 65 / 130' ,'60 / 108 / 216' ,'0.6' ,'25%', '1')," +
                    "('Ezreal', 'Glacial', 'Ranger', '-', 'Ice Shot. Ezreal fires a shard of ice at the lowest HP unit, dealing magic damage and applying on-hit effects. Damage: 200 / 400 / 800. Cast Time: 0.25', 'B', '3', '600 / 1080 / 2160', '30', '0', '20' ,'20' ,'46 / 82 / 164' ,'65 / 117 / 234' ,'0.7' ,'25%', '3')," +
                    "('KogMaw', 'Poison', 'Predator', '-', 'Living Artillery. KogMaw fires a living artillery shell at a random enemy, dealing damage. Damage: 125 / 275 / 425. Cast Time: 0.25', 'B', '1', '500 / 900 / 1800', '40', '0', '20' ,'20' ,'18 / 32 / 63' ,'25 / 45 / 90' ,'0.7' ,'25%', '3')," +
                    "('LeBlanc', 'Woodland', 'Assassin', 'Mage', 'Ethereal Chains. Leblanc flings an illusory chain toward a random enemy, dealing damage and stunning them after 1.5 seconds. Damage: 200 / 450 / 800', 'B', '2', '550 / 990 / 1980', '80', '50', '20' ,'20' ,'39 / 69 / 139' ,'55 / 99 / 198' ,'0.7' ,'25%', '2')," +
                    "('Malzahar', 'Shadow', 'Summoner', '-', 'Shadow Swarm. Malzahar creates a shadow portal, summoning Shadow Spawns. The Shadow Spawns hit for magic damage each attack. Shadow Spawn benefit from active Shadow trait bonuses. Number of Spirits: 2 / 3 / 4. Spirit Damage: 30 / 60 / 90. Spirit Health: 250', 'B', '2', '550 / 990 / 1980', '125', '75', '20' ,'20' ,'26 / 47 / 94' ,'40 / 72 / 144' ,'0.65' ,'25%', '3')," +
                    "('Maokai', 'Woodland', 'Druid', '-', 'Sap Magic. After taking damage from a spell, Maokais next attack will heal him. Heal Amount: 100 / 150 / 200', 'B', '1', '650 / 1170 / 2340', '0', '0', '35' ,'20' ,'28 / 50 / 99' ,'55 / 99 / 198' ,'0.5' ,'25%', '1')," +
                    "('Nautilus', 'Ocean', 'Warden', '-', 'Depth Charge. Nautilus sends out a depth charge that seeks out the furthest enemy champion, knocking them up and stunning them. It also deals damage to all enemies it passes. Damage: 100 / 200 / 400. Stun Duration: 3 / 4 / 6', 'B', '3', '850 / 1530 / 3060', '125', '50', '40' ,'20' ,'33 / 59 / 119' ,'55 / 99 / 198' ,'0.6' ,'25%', '1')," +
                    "('Ornn', 'Electric', 'Warden', '-', 'Lightning Breath. Ornn unleashes lightning bolts in a cone in front of him, dealing damage and increasing their chance to be critical struck by 20% for 4 seconds. Damage: 100 / 200 / 300', 'B', '1', '650 / 1170 / 2340', '75', '0', '40' ,'20' ,'28 / 50 / 99' ,'50 / 90 / 180' ,'0.55' ,'25%', '1')," +
                    "('RekSai', 'Steel', 'Predator', '-', 'Furious Bite. RekSai bites an enemy dealing true damage. Damage: 250 / 550 / 850', 'B', '2', '650 / 1170 / 2340', '75', '0', '30' ,'20' ,'46 / 82 / 164' ,'65 / 117 / 234' ,'0.7' ,'25%', '1')," +
                    "('Renekton', 'Desert', 'Berserker', '-', 'Cull the Meek. Renekton swings his blade, dealing damage to nearby enemies and restoring health. Damage: 150 / 275 / 400. Heal Amount: 150 / 225 / 300', 'B', '1', '600 / 1080 / 2160', '100', '0', '35' ,'20' ,'36 / 65 / 130' ,'60 / 108 / 216' ,'0.6' ,'25%', '1')," +
                    "('Sivir', 'Desert', 'Blademaster', '-', 'Ricochet. For the next 5 seconds, Sivirs attacks will bounce up to 10 times to nearby enemies, dealing damage and applying on-hit effects. Damage: 100% / 125% / 150%', 'B', '3', '600 / 1080 / 2160', '65', '0', '25' ,'20' ,'39 / 69 / 139' ,'55 / 99 / 198' ,'0.7' ,'25%', '3')," +
                    "('Skarner', 'Crystal', 'Predator', '-', 'Crystalline Exoskeleton. Skarner is shielded for 8 seconds. While the shield persists, Skarner gains attack speed. Shield Amount: 150 / 450 / 750. Attack Speed Bonus: 30% / 65% / 100%', 'B', '2', '650 / 1170 / 2340', '65', '0', '35' ,'20' ,'39 / 70 / 140' ,'60 / 108 / 216' ,'0.65' ,'25%', '1')," +
                    "('Soraka', 'Light', 'Mystic', '-', 'Equinox. Soraka creates a zone at a random enemys location, dealing magic damage and preventing mana from being restored to enemies inside. Damage: 150 / 300 / 450. Duration: 3 / 5 / 7', 'B', '3', '600 / 1080 / 2160', '60', '0', '20' ,'20' ,'28 / 50 / 101' ,'40 / 72 / 144' ,'0.7' ,'25%', '3')," +
                    "('Syndra', 'Ocean', 'Mage', '-', 'Hydro Sphere. Syndra conjures a sphere of water near a random enemy which explodes dealing magic damage to all enemies hit. Damage: 175 / 350 / 600', 'B', '2', '500 / 900 / 1800', '80', '0', '20' ,'20' ,'28 / 50 / 101' ,'40 / 72 / 144' ,'0.7' ,'25%', '3')," +
                    "('Thresh', 'Ocean', 'Warden', '-', 'Deep Sea Lantern. Thresh throws his lantern to the lowest-health ally, shielding them and nearby allies for 5 seconds. Shield Amount: 250 / 400 / 600. Cast Time: 0.25', 'B', '2', '700 / 1260 / 2520', '125', '50', '40' ,'20' ,'30 / 54 / 109' ,'55 / 99 / 198' ,'0.55' ,'25%', '2')," +
                    "('Twitch', 'Poison', 'Ranger', '-', 'Spray and Pray. Twitch gains increased damage and unlimited range for 8 seconds. Bonus Damage: 125% / 150% / 200%', 'B', '4', '650 / 1170 / 2340', '90', '0', '20' ,'20' ,'45 / 81 / 162' ,'60 / 108 / 216' ,'0.75' ,'25%', '4')," +
                    "('Yasuo', 'Cloud', 'Blademaster', '-', 'Last Breath. Yasuo blinks to the enemy with the most items and knocks them up, holding them airborn for 1 second and hitting them, dealing basic attack damage and applying on-hit effects. Hits: 4 / 5 / 6', 'B', '2', '600 / 1080 / 2160', '100', '0', '30' ,'20' ,'42 / 76 / 151' ,'60 / 108 / 216' ,'0.7' ,'25%', '1')," +
                    "('Zyra', 'Inferno', 'Summoner', '-', 'Rampant Growth. Zyra summons two Flame Spitters at a random location at the edge of the arena. The Flame Spitters attack the nearest enemy for 3 seconds, dealing damage per attack a total of 4 times. Damage: 70 / 80 / 90. Number of Plants: 2 / 3 / 4', 'B', '1', '500 / 900 / 1800', '75', '0', '20' ,'20' ,'16 / 29 / 59' ,'25 / 45 / 90' ,'0.65' ,'25%', '3')," +
                    "('Amumu', 'Inferno', 'Warden', '-', 'Curse of the Sad Mummy. Amumus rage explodes, dealing magic damage to enemies in an area around him, and stunning them for 1.5 seconds. Damage: 250 / 500 / 1337. Range: 2 / 3 / 4', 'B', '5', '900 / 1620 / 3240', '150', '50', '150' ,'20' ,'41 / 74 / 149' ,'55 / 99 / 198' ,'0.75' ,'25%', '1')," +
                    "('Aatrox', 'Light', 'Blademaster', '-', 'The Darkin Blade. Aatrox cleaves the area in front of him, dealing damage to enemies inside it. Damage: 250 / 500 / 1000', 'C', '3', '700 / 1260 / 2520', '70', '0', '35' ,'20' ,'42 / 76 / 152' ,'65 / 117 / 234' ,'0.7' ,'25%', '1')," +
                    "('Azir', 'Desert', 'Summoner', '-', 'Arise!. Azir summons a Sand Soldier for 6 seconds. Sand Soldiers attack nearby enemies whenever Azir attacks, dealing magic damage in a line. Damage: 125 / 250 / 375', 'C', '3', '600 / 1080 / 2160', '100', '0', '20' ,'20' ,'44 / 79 / 158' ,'55 / 99 / 198' ,'0.8' ,'25%', '3')," +
                    "('Diana', 'Inferno', 'Assassin', '-', 'Flame Cascade. Diana creates orbs that spin around her and explode upon contact with an enemy, dealing magic damage. Additionally, Diane gains a shield for 3 seconds. Damage: 80 / 100 / 120. Shield Amount: 150 / 250 / 350. Number of Orbs: 3 / 4 / 5', 'C', '-', '1', '550 / 990 / 1980', '100', '0', '20' ,'20' ,'35 / 63 / 126' ,'50 / 90 / 180' ,'0.7' ,'25%', '1')," +
                    "('Ivern', 'Woodland', 'Druid', '-', 'Triggerseed. Ivern shields the ally with the lowest health for 5 seconds. Shield Amount: 200 / 300 / 400', 'C', '1', '600 / 1080 / 2160', '100', '50', '25' ,'20' ,'30 / 54 / 108' ,'50 / 90 / 180' ,'0.6' ,'25%', '2')," +
                    "('Sion', 'Shadow', 'Berserker', '-', 'Decimating Smash. Sion smashes his axe into the ground after a short delay, dealing damage and knocking up enemies in the area. Damage: 200 / 400 / 800', 'C', '3', '850 / 1530 / 3060', '125', '0', '35' ,'20' ,'42 / 76 / 152' ,'65 / 117 / 234' ,'0.65' ,'25%', '1')," +
                    "('Varus', 'Inferno', 'Ranger', '-', 'Piercing Arrow. Varus charges for 1.5 seconds and fires an arrow, dealing damage to all enemies in a line. Damage: 225 / 450 / 675', 'C', '2', '550 / 990 / 1980', '100', '50', '25' ,'20' ,'35 / 63 / 126' ,'60 / 108 / 216' ,'0.75' ,'25%', '4')," +
                    "('Veigar', 'Shadow', 'Mage', '-', 'Primordial Burst. Veigar blasts an enemy with magical energy, dealing damage. This spell instantly kills if the enemy is a lower star level than Veigar. Damage: 300 / 600 / 900', 'C', '3', '600 / 1080 / 2160', '60', '0', '20' ,'20' ,'30 / 54 / 108' ,'50 / 90 / 180' ,'0.6' ,'25%', '3')," +
                    "('Vladimir', 'Ocean', 'Mage', '-', 'Drain. Vladimir damages a target enemy, healing himself for the damage dealt. Damage: 200 / 325 / 450', 'C', '1', '550 / 990 / 1980', '75', '0', '35' ,'20' ,'26 / 47 / 94' ,'40 / 72 / 144' ,'0.65' ,'25%', '2')," +
                    "('Braum', 'Glacial', 'Warden', '-', 'Unbreakable. Braum gains a barrier that reduces incoming damage. Damage Reduction: 70% / 80% / 90%. Duration: 4', 'D', '2', '750 / 1350 / 2700', '65', '0', '60' ,'20' ,'24 / 43 / 86' ,'40 / 72 / 144' ,'0.6' ,'25%', '1')," +
                    "('Jax', 'Light', 'Berserker', '-', 'Counter Strike. Jax dodges all incoming attacks for 2 seconds, then strikes nearby enemies, stunning them for 1.5 seconds. Damage: 150 / 250 / 450', 'D', '2', '650 / 1170 / 2340', '125', '50', '35' ,'20' ,'40 / 72 / 144' ,'50 / 90 / 180' ,'0.8' ,'25%', '1')," +
                    "('Nasus', 'Light', 'Warden', '-', 'Fury of the Dawn. Nasus surrounds himself with light for 7 seconds, gaining bonus health and damaging adjacent enemies each second. Damage: 50 / 70 / 90. Bonus Health: 250 / 400 / 500', 'D', '1', '650 / 1170 / 2340', '100', '0', '40' ,'20' ,'28 / 50 / 99' ,'50 / 90 / 180' ,'0.55' ,'25%', '1')," +
                    "('Neeko', 'Woodland', 'Druid', '-', 'Blooming Burst. Neeko throws a seed at a random target, exploding three times with increasing radius, dealing damage to all enemies hit by each explosion. Damage: 100 / 200 / 350.', 'D', '2', '500 / 900 / 1800', '80', '0', '20', '20' ,'31 / 57 / 113' ,'45 / 81 / 162' ,'0.7' ,'25%' ,'3')," +
                    "('Vayne', 'Light', 'Ranger', '-', 'Silver Bolts. Vayne deals bonus true damage every third attack based on the enemys maximum health. Bonus Damage: 9% / 12% / 15%', 'D', '1', '500 / 900 / 1800', '0', '0', '25', '20' ,'30 / 54 / 108' ,'40 / 72 / 144 ' ,'0.75' ,'25%' ,'3')," +
                    "('Warwick', 'Glacial', 'Predator', '-', 'Infinite Duress. Warwick pounces onto the lowest health enemy, stunning, damaging, and applying on-hit effects while healing himself. Damage: 150 / 225 / 300. Hits: 3. Duration: 1.5', 'D', '1', '650 / 1170 / 2340', '150', '50', '30', '20' ,'30 / 54 / 108' ,'50 / 90 / 180' ,'0.6' ,'25%' ,'1')," +
                    "('Taliyah', 'Mountain', 'Mage', '-', 'Seismic Shove. Taliyah causes the ground to rise under the enemy with the most Mana, dealing damage and either pushing or pulling them toward her. Damage: 150 / 350 / 550. Stun Duration: 2', 'E', '1', '500 / 900 / 1800', '80', '50', '20', '20' ,'26 / 47 / 94' ,'40 / 72 / 144' ,'0.65' ,'25%' ,'3');";
            db.execSQL(datosCampeon);

            db.setTransactionSuccessful();
        }catch (SQLException exc){
            Log.e(LOG_TAG, "error creando tabla" + exc.getMessage());
        }finally {
            db.endTransaction();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.beginTransaction();

        try {
            db.execSQL( "DROP TABLE IF EXISTS item" );
            db.execSQL( "DROP TABLE IF EXISTS campeon" );
            db.execSQL( "DROP TABLE IF EXISTS origin" );
            db.execSQL( "DROP TABLE IF EXISTS clase" );
            db.setTransactionSuccessful();
        }catch (SQLException exc) {
            Log.e(LOG_TAG, "error borrando la tabla" + exc.getMessage());
        }finally {
            db.endTransaction();
        }

        this.onCreate( db  );
    }

    public List<Champion> recuperaTodosLosCampeones (){
        final List<Champion> TORET = new ArrayList<>();
        final SQLiteDatabase DB = this.getReadableDatabase();
        final Cursor CURSOR = DB.query("campeon", null,null,null,null,null, null);
        if(CURSOR.moveToFirst()){
            do{
                String Name = CURSOR.getString(CURSOR.getColumnIndexOrThrow("nombre"));
                String Origin = CURSOR.getString(CURSOR.getColumnIndexOrThrow("origen"));
                String ChampClass = CURSOR.getString(CURSOR.getColumnIndexOrThrow("clase"));
                String OriginClass = CURSOR.getString(CURSOR.getColumnIndexOrThrow("claseOrigen"));
                String Description = CURSOR.getString(CURSOR.getColumnIndexOrThrow("descripcion"));
                char Tier = CURSOR.getString(CURSOR.getColumnIndexOrThrow("tier")).charAt(0);
                int Cost = Integer.parseInt(CURSOR.getString(CURSOR.getColumnIndexOrThrow("coste")));
                String Health = CURSOR.getString(CURSOR.getColumnIndexOrThrow("vida"));
                int Mana = Integer.parseInt(CURSOR.getString(CURSOR.getColumnIndexOrThrow("mana")));
                int InitialMana = Integer.parseInt(CURSOR.getString(CURSOR.getColumnIndexOrThrow("mana inicial")));
                int Armor = Integer.parseInt(CURSOR.getString(CURSOR.getColumnIndexOrThrow("armadura")));
                int MR = Integer.parseInt(CURSOR.getString(CURSOR.getColumnIndexOrThrow("mr")));
                String DPS = CURSOR.getString(CURSOR.getColumnIndexOrThrow("dps"));
                String Damage = CURSOR.getString(CURSOR.getColumnIndexOrThrow("daño"));
                double AtkSpd = Double.parseDouble(CURSOR.getString(CURSOR.getColumnIndexOrThrow("vAtaque")));
                String CritRate = CURSOR.getString(CURSOR.getColumnIndexOrThrow("critico"));
                int Range = Integer.parseInt(CURSOR.getString(CURSOR.getColumnIndexOrThrow("alcance")));

                TORET.add(new Champion(Name,Origin,ChampClass,OriginClass,Description,Tier,Cost,Health,Mana,InitialMana,Armor,MR,DPS,Damage,AtkSpd,CritRate,Range));
            }while(CURSOR.moveToNext());
        }

        return TORET;
    }

    public List<Item> recuperaTodosLosObjetos(){
        final List<Item> TORET = new ArrayList<>();
        final SQLiteDatabase DB = this.getReadableDatabase();
        final Cursor CURSOR = DB.query("item", null,null,null,null,null,null);
        if(CURSOR.moveToFirst()){
            do{
                String Name = CURSOR.getString(CURSOR.getColumnIndexOrThrow("nombre"));
                String Item1 = CURSOR.getString(CURSOR.getColumnIndexOrThrow("objeto1"));
                String Item2 = CURSOR.getString(CURSOR.getColumnIndexOrThrow("objeto2"));
                String Description = CURSOR.getString(CURSOR.getColumnIndexOrThrow("descripcion"));
                String Tier = CURSOR.getString(CURSOR.getColumnIndexOrThrow("tier"));

                TORET.add(new Item(Name,Item1,Item2,Description,Tier));
            }while(CURSOR.moveToNext());
        }
        return TORET;
    }

    public List<ChampOrigin> recuperaTodosLosOrigenes(){
        final List<ChampOrigin> TORET = new ArrayList<>();
        final SQLiteDatabase DB = this.getReadableDatabase();
        final Cursor CURSOR = DB.query("origen", null,null,null,null,null,null);
        if(CURSOR.moveToFirst()){
            do{
                String Name = CURSOR.getString(CURSOR.getColumnIndexOrThrow("nombre"));
                String Description = CURSOR.getString(CURSOR.getColumnIndexOrThrow("descripcion"));

                TORET.add(new ChampOrigin(Name, Description));
            }while(CURSOR.moveToNext());
        }
        return TORET;
    }
    public List<ChampClass> recuperaTodasLasClases(){
        final List<ChampClass> TORET = new ArrayList<>();
        final SQLiteDatabase DB = this.getReadableDatabase();
        final Cursor CURSOR = DB.query("clase", null,null,null,null,null,null);
        if(CURSOR.moveToFirst()){
            do{
                String Name = CURSOR.getString(CURSOR.getColumnIndexOrThrow("nombre"));
                String Description = CURSOR.getString(CURSOR.getColumnIndexOrThrow("descripcion"));

                TORET.add(new ChampClass(Name, Description));
            }while(CURSOR.moveToNext());
        }
        return TORET;
    }

}
