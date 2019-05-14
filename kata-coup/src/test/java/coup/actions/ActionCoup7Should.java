package coup.actions;

import coup.Action;
import coup.ActionTests;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class ActionCoup7Should extends ActionTests {

    // Action: Pay 7 cons, choose the player to lose Influence
    // Action cannot be challenged

    // Block: Cannot be blocked

    @Before
    public void before() throws Exception {
        super.before();
        action = new Coup7();
    }

    // Action costs money
    @Test(expected = Exception.class)
    public void player_needs_money_to_do_the_action() throws Exception {
        // when
        game.setPlayerPlayingThisHand(1);
        game.setTargetPlayerForAssasination(2);

        game.doAction(action);
    }

    // Action
    @Test
    public void player_does_action() throws Exception {
        // given
        game.takeCoinFromTreasury();
        game.takeCoinFromTreasury();
        game.takeCoinFromTreasury();
        game.takeCoinFromTreasury();
        game.takeCoinFromTreasury();

        game.player(1).addCoin();
        game.player(1).addCoin();
        game.player(1).addCoin();
        game.player(1).addCoin();
        game.player(1).addCoin();

        // when
        game.setPlayerPlayingThisHand(1);
        game.setTargetPlayerForAssasination(2);

        game.doAction(action);

        // then
        Assert.assertEquals(48, game.treasury());

        Assert.assertEquals(2, game.player(1).cardsInGame());
        Assert.assertEquals(0, game.player(1).coins());

        Assert.assertEquals(1, game.player(2).cardsInGame());
        Assert.assertEquals(2, game.player(2).coins());
    }

    // Action cannot be challenged
    @Test(expected = Exception.class)
    public void player_calls_the_bluff_over_action() throws Exception {
        // given
        Action action = new Coup7();

        // when
        game.setPlayerPlayingThisHand(1);
        game.doAction(action);

        game.doPlayerCallingTheBluffOnTheAction(2, 1, action);
    }

    // Action can be challenged
    // Challenger (wins)
    @Ignore
    @Test
    public void player_does_action_and_other_player_calls_the_bluff_and_wins_the_call() throws Exception {

    }

    // Action can be challenged
    // Challenger (lose)
    @Ignore
    @Test
    public void player_does_action_and_other_calls_the_bluff_and_lose_the_call() throws Exception {

    }

    // Action cannot be blocked
    @Test(expected = Exception.class)
    public void player_blocks_action() throws Exception {
        // given
        Action action = new Coup7();

        // when
        game.setPlayerPlayingThisHand(1);
        game.doAction(action);

        game.setPlayerBlocksAction(2);
        game.doBlockAction(action);
    }

    // Action can be blocked
    @Ignore
    @Test
    public void player_does_action_and_gets_block() throws Exception {

    }

    // Action can be blocked
    // Block can be challenged
    // Challenger wins
    @Ignore
    @Test
    public void player_does_action_and_gets_block_but_a_player_calls_the_bluff_on_the_block_and_wins_the_call() throws Exception {

    }

    // Action can be blocked
    // Block can be challenged
    // Challenger lose
    @Ignore
    @Test
    public void player_does_action_and_gets_block_but_a_player_calls_the_bluff_on_the_block_and_lose_the_call() throws Exception {

    }

    // Action can be blocked
    // Block cannot be challenged
    @Ignore
    @Test(expected = Exception.class)
    public void player_does_action_and_gets_block_but_a_player_calls_the_bluff_on_the_block() throws Exception {

    }

}
