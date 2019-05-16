package coup.actions;

import coup.Action;
import coup.Game;

public class ForeignAid extends Action {

    // Action: Take two coins from the treasury
    // Action cannot be challenged

    // Block: Can be blocked by a player claiming the Duke
    // Block can be challenged

    // Setup
    public boolean canThisActionBeChallenged() {
        return false;
    }

    // Action
    public void doActionInternal(Game game) throws Exception {
        game.playerTakeCoinsFromTreasury(game.playerDoingTheAction,2);
    }

    // Block Action
    public void doBlockActionInternal(Game game) throws Exception {
        game.playerReturnCoinsToTreasury(game.playerDoingTheAction,2);
    }

}
