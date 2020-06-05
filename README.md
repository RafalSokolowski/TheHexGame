###### First draft of the game’s description (row bullet points, to be improved and polished) :

# I. Main assumptions :
- Turn-based mini-strategy game
- The game is inspired by Antiyoy (https://github.com/yiotro/Antiyoy)
- “Easy to understand, hard to master”
- This release allows for 2 players (human vs. human) only
- Next release will introduce the AI mode
- Predefined hex-board to play on
- ...

# II Economy :
- Each unit consumes predefined amount of gold each turn (turn-cost), eg. Peasant - 2, Knight - 6 and King - 18
- Gold can be generated by farms and hex-cells (eg. each farm generates # gold of last farm + 4, each hex-cell generates +1 gold)
- The bigger the territory the higher the income, the higher the number of farms the higher the income
- Territory can be taken over by the opponent (the flow of gold is decreased by 1)
- Owned territory can be cut by the opponent into two / several pieces (then the gold flow is separated / divided for the regions)
- If the gold flow is lower than the turn-cost of the units and defence towers - all units are dying
- ...

## II a Trees :
- Tree is blocking a cash flow from the cell (while grow)
- Tree can be cut by the unit only and bring additional 3 units of gold
- Cell with tree cannot be built over
- Trees are grown randomly (especially at the border of the map)
- ...

## II b Units :
- Three types of units: (1) Peasant, Knight, and King or (2) Pikeman, Knight and Cavalry
- In the (1) scenario Peasant can be killed by Knight and King, Knight can be killed by King and King can be killed by the other King (who attacked first)
- In the (2) scenario Pikeman can be killed by Knight, Knight by Cavalry and Cavalry by Pikeman (triangle of fight / strength)
- Units can move by one cell in any direction – (1) not taken by stronger unit + 1 cell, (2) not taken by the tower (unless it is King / Cavalry), (3) cell is available (ie. not disabled / off the game)
- Units can be bought at whichever time of the game
- …

## II c Fortifications :
- One type of the fortification (tower which is guarding the closest hex-slots and can be destroyed by knights only)
- One type of farm (which generates the predefined amount of gold each turn)... the cost of new farm equals the cost of the last farm plus # units of gold
- …

# III Tactics / rules :
- The player who taken over each and every cell in the board is winning the game
- The player who has 8 times higher the income then the opponent is winning the game
- Collect as many hex-cells as possible at the beginning of the game, pay attention to amount of farms, keep appropriate balance / diversity between farms, cells, towers and units
- ...

# IV. TheHexGame team (THG Team) :
- Project mentor: **Grand Master Piotr Wrona** (aka Piotrolot1)
- Project contributor (databases and frontend): **Lady Weronika Konopka** (aka Bere Nika)
- Project contributor (backend): **Sulfugi Piotr Zebzda** (aka  SolfugaSoft)
- Project contributor (backend and the sip of frontend): **Padawan Rafal Sokolowski** (aka Rav)
