const GAMES = [
  {
    "id": "g0",
    "name": "Diablo II",
    "genre": "arpg",
    "steam": 0,
    "wiki": "Diablo II",
    "accent": "#e49a65",
    "aliases": [
      "d2",
      "d2r",
      "diablo 2",
      "diablo ii resurrected"
    ]
  },
  {
    "id": "g1",
    "name": "Counter-Strike 2",
    "genre": "shooter",
    "steam": 730,
    "wiki": "Counter-Strike 2",
    "accent": "#89b8df"
  },
  {
    "id": "g2",
    "name": "Dota 2",
    "genre": "strategy",
    "steam": 570,
    "wiki": "Dota 2",
    "accent": "#be9ee5"
  },
  {
    "id": "g3",
    "name": "PUBG: Battlegrounds",
    "genre": "shooter",
    "steam": 578080,
    "wiki": "PUBG: Battlegrounds",
    "accent": "#89b8df"
  },
  {
    "id": "g4",
    "name": "Apex Legends",
    "genre": "shooter",
    "steam": 1172470,
    "wiki": "Apex Legends",
    "accent": "#89b8df"
  },
  {
    "id": "g5",
    "name": "Fortnite",
    "genre": "shooter",
    "steam": 0,
    "wiki": "Fortnite",
    "accent": "#89b8df"
  },
  {
    "id": "g6",
    "name": "Minecraft",
    "genre": "survival",
    "steam": 0,
    "wiki": "Minecraft",
    "accent": "#9dc58b",
    "aliases": [
      "mc"
    ]
  },
  {
    "id": "g7",
    "name": "Roblox",
    "genre": "sandbox",
    "steam": 0,
    "wiki": "Roblox",
    "accent": "#a6c6ed"
  },
  {
    "id": "g8",
    "name": "League of Legends",
    "genre": "strategy",
    "steam": 0,
    "wiki": "League of Legends",
    "accent": "#be9ee5"
  },
  {
    "id": "g9",
    "name": "Valorant",
    "genre": "shooter",
    "steam": 0,
    "wiki": "Valorant",
    "accent": "#89b8df"
  },
  {
    "id": "g10",
    "name": "Grand Theft Auto V",
    "genre": "adventure",
    "steam": 271590,
    "wiki": "Grand Theft Auto V",
    "accent": "#79bfac"
  },
  {
    "id": "g11",
    "name": "Grand Theft Auto Online",
    "genre": "adventure",
    "steam": 0,
    "wiki": "Grand Theft Auto Online",
    "accent": "#79bfac"
  },
  {
    "id": "g12",
    "name": "Call of Duty: Warzone",
    "genre": "shooter",
    "steam": 0,
    "wiki": "Call of Duty: Warzone",
    "accent": "#89b8df"
  },
  {
    "id": "g13",
    "name": "Overwatch 2",
    "genre": "shooter",
    "steam": 2357570,
    "wiki": "Overwatch 2",
    "accent": "#89b8df"
  },
  {
    "id": "g14",
    "name": "Marvel Rivals",
    "genre": "shooter",
    "steam": 2767030,
    "wiki": "Marvel Rivals",
    "accent": "#89b8df"
  },
  {
    "id": "g15",
    "name": "Rocket League",
    "genre": "sports",
    "steam": 252950,
    "wiki": "Rocket League",
    "accent": "#83d6ce"
  },
  {
    "id": "g16",
    "name": "Tom Clancy's Rainbow Six Siege",
    "genre": "shooter",
    "steam": 359550,
    "wiki": "Tom Clancy's Rainbow Six Siege",
    "accent": "#89b8df"
  },
  {
    "id": "g17",
    "name": "Destiny 2",
    "genre": "shooter",
    "steam": 1085660,
    "wiki": "Destiny 2",
    "accent": "#89b8df"
  },
  {
    "id": "g18",
    "name": "Warframe",
    "genre": "arpg",
    "steam": 230410,
    "wiki": "Warframe",
    "accent": "#df9765"
  },
  {
    "id": "g19",
    "name": "Team Fortress 2",
    "genre": "shooter",
    "steam": 440,
    "wiki": "Team Fortress 2",
    "accent": "#89b8df"
  },
  {
    "id": "g20",
    "name": "Rust",
    "genre": "survival",
    "steam": 252490,
    "wiki": "Rust",
    "accent": "#9dc58b"
  },
  {
    "id": "g21",
    "name": "DayZ",
    "genre": "survival",
    "steam": 221100,
    "wiki": "DayZ",
    "accent": "#9dc58b"
  },
  {
    "id": "g22",
    "name": "ARK: Survival Ascended",
    "genre": "survival",
    "steam": 2399830,
    "wiki": "ARK: Survival Ascended",
    "accent": "#9dc58b"
  },
  {
    "id": "g23",
    "name": "Palworld",
    "genre": "survival",
    "steam": 1623730,
    "wiki": "Palworld",
    "accent": "#9dc58b"
  },
  {
    "id": "g24",
    "name": "Helldivers 2",
    "genre": "shooter",
    "steam": 553850,
    "wiki": "Helldivers 2",
    "accent": "#89b8df"
  },
  {
    "id": "g25",
    "name": "Dead by Daylight",
    "genre": "survival",
    "steam": 381210,
    "wiki": "Dead by Daylight",
    "accent": "#9dc58b"
  },
  {
    "id": "g26",
    "name": "War Thunder",
    "genre": "simulation",
    "steam": 236390,
    "wiki": "War Thunder",
    "accent": "#d9bd7e"
  },
  {
    "id": "g27",
    "name": "World of Tanks",
    "genre": "simulation",
    "steam": 1407200,
    "wiki": "World of Tanks",
    "accent": "#d9bd7e"
  },
  {
    "id": "g28",
    "name": "World of Warcraft",
    "genre": "rpg",
    "steam": 0,
    "wiki": "World of Warcraft",
    "accent": "#b3a2eb"
  },
  {
    "id": "g29",
    "name": "Final Fantasy XIV",
    "genre": "rpg",
    "steam": 39210,
    "wiki": "Final Fantasy XIV",
    "accent": "#b3a2eb"
  },
  {
    "id": "g30",
    "name": "The Elder Scrolls Online",
    "genre": "rpg",
    "steam": 306130,
    "wiki": "The Elder Scrolls Online",
    "accent": "#b3a2eb"
  },
  {
    "id": "g31",
    "name": "Guild Wars 2",
    "genre": "rpg",
    "steam": 1284210,
    "wiki": "Guild Wars 2",
    "accent": "#b3a2eb"
  },
  {
    "id": "g32",
    "name": "Old School RuneScape",
    "genre": "rpg",
    "steam": 1343370,
    "wiki": "Old School RuneScape",
    "accent": "#b3a2eb"
  },
  {
    "id": "g33",
    "name": "RuneScape",
    "genre": "rpg",
    "steam": 1343400,
    "wiki": "RuneScape",
    "accent": "#b3a2eb"
  },
  {
    "id": "g34",
    "name": "Lost Ark",
    "genre": "arpg",
    "steam": 1599340,
    "wiki": "Lost Ark",
    "accent": "#df9765"
  },
  {
    "id": "g35",
    "name": "Black Desert Online",
    "genre": "rpg",
    "steam": 582660,
    "wiki": "Black Desert Online",
    "accent": "#b3a2eb"
  },
  {
    "id": "g36",
    "name": "Path of Exile",
    "genre": "arpg",
    "steam": 238960,
    "wiki": "Path of Exile",
    "accent": "#df9765"
  },
  {
    "id": "g37",
    "name": "Path of Exile 2",
    "genre": "arpg",
    "steam": 2694490,
    "wiki": "Path of Exile 2",
    "accent": "#df9765"
  },
  {
    "id": "g38",
    "name": "Diablo IV",
    "genre": "arpg",
    "steam": 2344520,
    "wiki": "Diablo IV",
    "accent": "#df9765"
  },
  {
    "id": "g39",
    "name": "Diablo III",
    "genre": "arpg",
    "steam": 0,
    "wiki": "Diablo III",
    "accent": "#df9765"
  },
  {
    "id": "g40",
    "name": "Last Epoch",
    "genre": "arpg",
    "steam": 899770,
    "wiki": "Last Epoch",
    "accent": "#df9765"
  },
  {
    "id": "g41",
    "name": "Grim Dawn",
    "genre": "arpg",
    "steam": 219990,
    "wiki": "Grim Dawn",
    "accent": "#df9765"
  },
  {
    "id": "g42",
    "name": "Elden Ring",
    "genre": "souls",
    "steam": 1245620,
    "wiki": "Elden Ring",
    "accent": "#d0b47a",
    "aliases": [
      "er"
    ]
  },
  {
    "id": "g43",
    "name": "Dark Souls III",
    "genre": "souls",
    "steam": 374320,
    "wiki": "Dark Souls III",
    "accent": "#d0b47a"
  },
  {
    "id": "g44",
    "name": "Sekiro: Shadows Die Twice",
    "genre": "souls",
    "steam": 814380,
    "wiki": "Sekiro: Shadows Die Twice",
    "accent": "#d0b47a"
  },
  {
    "id": "g45",
    "name": "Lies of P",
    "genre": "souls",
    "steam": 1627720,
    "wiki": "Lies of P",
    "accent": "#d0b47a"
  },
  {
    "id": "g46",
    "name": "Black Myth: Wukong",
    "genre": "souls",
    "steam": 2358720,
    "wiki": "Black Myth: Wukong",
    "accent": "#d0b47a"
  },
  {
    "id": "g47",
    "name": "Monster Hunter: World",
    "genre": "arpg",
    "steam": 582010,
    "wiki": "Monster Hunter: World",
    "accent": "#df9765"
  },
  {
    "id": "g48",
    "name": "Monster Hunter Rise",
    "genre": "arpg",
    "steam": 1446780,
    "wiki": "Monster Hunter Rise",
    "accent": "#df9765"
  },
  {
    "id": "g49",
    "name": "Monster Hunter Wilds",
    "genre": "arpg",
    "steam": 2246340,
    "wiki": "Monster Hunter Wilds",
    "accent": "#df9765"
  },
  {
    "id": "g50",
    "name": "Baldur's Gate 3",
    "genre": "rpg",
    "steam": 1086940,
    "wiki": "Baldur's Gate 3",
    "accent": "#b3a2eb"
  },
  {
    "id": "g51",
    "name": "Cyberpunk 2077",
    "genre": "rpg",
    "steam": 1091500,
    "wiki": "Cyberpunk 2077",
    "accent": "#b3a2eb"
  },
  {
    "id": "g52",
    "name": "The Witcher 3: Wild Hunt",
    "genre": "rpg",
    "steam": 292030,
    "wiki": "The Witcher 3: Wild Hunt",
    "accent": "#b3a2eb"
  },
  {
    "id": "g53",
    "name": "The Elder Scrolls V: Skyrim",
    "genre": "rpg",
    "steam": 489830,
    "wiki": "The Elder Scrolls V: Skyrim",
    "accent": "#b3a2eb"
  },
  {
    "id": "g54",
    "name": "Fallout 4",
    "genre": "rpg",
    "steam": 377160,
    "wiki": "Fallout 4",
    "accent": "#b3a2eb"
  },
  {
    "id": "g55",
    "name": "Fallout 76",
    "genre": "rpg",
    "steam": 1151340,
    "wiki": "Fallout 76",
    "accent": "#b3a2eb"
  },
  {
    "id": "g56",
    "name": "Starfield",
    "genre": "rpg",
    "steam": 1716740,
    "wiki": "Starfield",
    "accent": "#b3a2eb"
  },
  {
    "id": "g57",
    "name": "Red Dead Redemption 2",
    "genre": "adventure",
    "steam": 1174180,
    "wiki": "Red Dead Redemption 2",
    "accent": "#79bfac"
  },
  {
    "id": "g58",
    "name": "Hogwarts Legacy",
    "genre": "rpg",
    "steam": 990080,
    "wiki": "Hogwarts Legacy",
    "accent": "#b3a2eb"
  },
  {
    "id": "g59",
    "name": "Assassin's Creed Odyssey",
    "genre": "rpg",
    "steam": 812140,
    "wiki": "Assassin's Creed Odyssey",
    "accent": "#b3a2eb"
  },
  {
    "id": "g60",
    "name": "God of War",
    "genre": "adventure",
    "steam": 1593500,
    "wiki": "God of War",
    "accent": "#79bfac"
  },
  {
    "id": "g61",
    "name": "God of War Ragnarök",
    "genre": "adventure",
    "steam": 2322010,
    "wiki": "God of War Ragnarök",
    "accent": "#79bfac"
  },
  {
    "id": "g62",
    "name": "Horizon Zero Dawn",
    "genre": "adventure",
    "steam": 1151640,
    "wiki": "Horizon Zero Dawn",
    "accent": "#79bfac"
  },
  {
    "id": "g63",
    "name": "Ghost of Tsushima",
    "genre": "adventure",
    "steam": 2215430,
    "wiki": "Ghost of Tsushima",
    "accent": "#79bfac"
  },
  {
    "id": "g64",
    "name": "The Legend of Zelda: Breath of the Wild",
    "genre": "adventure",
    "steam": 0,
    "wiki": "The Legend of Zelda: Breath of the Wild",
    "accent": "#79bfac"
  },
  {
    "id": "g65",
    "name": "The Legend of Zelda: Tears of the Kingdom",
    "genre": "adventure",
    "steam": 0,
    "wiki": "The Legend of Zelda: Tears of the Kingdom",
    "accent": "#79bfac"
  },
  {
    "id": "g66",
    "name": "Genshin Impact",
    "genre": "rpg",
    "steam": 0,
    "wiki": "Genshin Impact",
    "accent": "#b3a2eb"
  },
  {
    "id": "g67",
    "name": "Honkai: Star Rail",
    "genre": "rpg",
    "steam": 0,
    "wiki": "Honkai: Star Rail",
    "accent": "#b3a2eb"
  },
  {
    "id": "g68",
    "name": "Zenless Zone Zero",
    "genre": "arpg",
    "steam": 0,
    "wiki": "Zenless Zone Zero",
    "accent": "#df9765"
  },
  {
    "id": "g69",
    "name": "Wuthering Waves",
    "genre": "arpg",
    "steam": 0,
    "wiki": "Wuthering Waves",
    "accent": "#df9765"
  },
  {
    "id": "g70",
    "name": "Stardew Valley",
    "genre": "simulation",
    "steam": 413150,
    "wiki": "Stardew Valley",
    "accent": "#d9bd7e"
  },
  {
    "id": "g71",
    "name": "Terraria",
    "genre": "survival",
    "steam": 105600,
    "wiki": "Terraria",
    "accent": "#9dc58b"
  },
  {
    "id": "g72",
    "name": "Valheim",
    "genre": "survival",
    "steam": 892970,
    "wiki": "Valheim",
    "accent": "#9dc58b"
  },
  {
    "id": "g73",
    "name": "No Man's Sky",
    "genre": "survival",
    "steam": 275850,
    "wiki": "No Man's Sky",
    "accent": "#9dc58b"
  },
  {
    "id": "g74",
    "name": "Subnautica",
    "genre": "survival",
    "steam": 264710,
    "wiki": "Subnautica",
    "accent": "#9dc58b"
  },
  {
    "id": "g75",
    "name": "Sons of the Forest",
    "genre": "survival",
    "steam": 1326470,
    "wiki": "Sons of the Forest",
    "accent": "#9dc58b"
  },
  {
    "id": "g76",
    "name": "Don't Starve Together",
    "genre": "survival",
    "steam": 322330,
    "wiki": "Don't Starve Together",
    "accent": "#9dc58b"
  },
  {
    "id": "g77",
    "name": "Project Zomboid",
    "genre": "survival",
    "steam": 108600,
    "wiki": "Project Zomboid",
    "accent": "#9dc58b"
  },
  {
    "id": "g78",
    "name": "7 Days to Die",
    "genre": "survival",
    "steam": 251570,
    "wiki": "7 Days to Die",
    "accent": "#9dc58b"
  },
  {
    "id": "g79",
    "name": "Satisfactory",
    "genre": "simulation",
    "steam": 526870,
    "wiki": "Satisfactory",
    "accent": "#d9bd7e"
  },
  {
    "id": "g80",
    "name": "Factorio",
    "genre": "simulation",
    "steam": 427520,
    "wiki": "Factorio",
    "accent": "#d9bd7e"
  },
  {
    "id": "g81",
    "name": "RimWorld",
    "genre": "simulation",
    "steam": 294100,
    "wiki": "RimWorld",
    "accent": "#d9bd7e"
  },
  {
    "id": "g82",
    "name": "Cities: Skylines",
    "genre": "simulation",
    "steam": 255710,
    "wiki": "Cities: Skylines",
    "accent": "#d9bd7e"
  },
  {
    "id": "g83",
    "name": "The Sims 4",
    "genre": "simulation",
    "steam": 1222670,
    "wiki": "The Sims 4",
    "accent": "#d9bd7e"
  },
  {
    "id": "g84",
    "name": "Sid Meier's Civilization VI",
    "genre": "strategy",
    "steam": 289070,
    "wiki": "Sid Meier's Civilization VI",
    "accent": "#be9ee5"
  },
  {
    "id": "g85",
    "name": "Age of Empires II: Definitive Edition",
    "genre": "strategy",
    "steam": 813780,
    "wiki": "Age of Empires II: Definitive Edition",
    "accent": "#be9ee5"
  },
  {
    "id": "g86",
    "name": "Total War: Warhammer III",
    "genre": "strategy",
    "steam": 1142710,
    "wiki": "Total War: Warhammer III",
    "accent": "#be9ee5"
  },
  {
    "id": "g87",
    "name": "Crusader Kings III",
    "genre": "strategy",
    "steam": 1158310,
    "wiki": "Crusader Kings III",
    "accent": "#be9ee5"
  },
  {
    "id": "g88",
    "name": "Hearts of Iron IV",
    "genre": "strategy",
    "steam": 394360,
    "wiki": "Hearts of Iron IV",
    "accent": "#be9ee5"
  },
  {
    "id": "g89",
    "name": "Football Manager 2024",
    "genre": "sports",
    "steam": 2252570,
    "wiki": "Football Manager 2024",
    "accent": "#83d6ce"
  },
  {
    "id": "g90",
    "name": "EA Sports FC 25",
    "genre": "sports",
    "steam": 2669320,
    "wiki": "EA Sports FC 25",
    "accent": "#83d6ce"
  },
  {
    "id": "g91",
    "name": "Forza Horizon 5",
    "genre": "sports",
    "steam": 1551360,
    "wiki": "Forza Horizon 5",
    "accent": "#83d6ce"
  },
  {
    "id": "g92",
    "name": "Gran Turismo 7",
    "genre": "sports",
    "steam": 0,
    "wiki": "Gran Turismo 7",
    "accent": "#83d6ce"
  },
  {
    "id": "g93",
    "name": "Euro Truck Simulator 2",
    "genre": "simulation",
    "steam": 227300,
    "wiki": "Euro Truck Simulator 2",
    "accent": "#d9bd7e"
  },
  {
    "id": "g94",
    "name": "Microsoft Flight Simulator (2020 video game)",
    "genre": "simulation",
    "steam": 1250410,
    "wiki": "Microsoft Flight Simulator (2020 video game)",
    "accent": "#d9bd7e"
  },
  {
    "id": "g95",
    "name": "Street Fighter 6",
    "genre": "fighting",
    "steam": 1364780,
    "wiki": "Street Fighter 6",
    "accent": "#ed8c9e"
  },
  {
    "id": "g96",
    "name": "Tekken 8",
    "genre": "fighting",
    "steam": 1778820,
    "wiki": "Tekken 8",
    "accent": "#ed8c9e"
  },
  {
    "id": "g97",
    "name": "Mortal Kombat 1",
    "genre": "fighting",
    "steam": 1971870,
    "wiki": "Mortal Kombat 1",
    "accent": "#ed8c9e"
  },
  {
    "id": "g98",
    "name": "Super Smash Bros. Ultimate",
    "genre": "fighting",
    "steam": 0,
    "wiki": "Super Smash Bros. Ultimate",
    "accent": "#ed8c9e"
  },
  {
    "id": "g99",
    "name": "Hades",
    "genre": "roguelike",
    "steam": 1145360,
    "wiki": "Hades (video game)",
    "accent": "#dd9cc6"
  },
  {
    "id": "g100",
    "name": "Balatro",
    "genre": "roguelike",
    "steam": 2379780,
    "wiki": "Balatro (video game)",
    "accent": "#dd9cc6"
  }
];
