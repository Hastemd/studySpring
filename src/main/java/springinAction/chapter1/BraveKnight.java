/**
 * Created by lijie on 2017/7/24.
 */
package springinAction.chapter1;

/**
 * auther lijie  2017/7/24.
 */
public class BraveKnight implements Knight {
    private Quest quest;

    public BraveKnight(Quest quest) {
        this.quest = quest;
    }

    @Override
    public void embarkOnQuest() {
        quest.embark();
    }
}