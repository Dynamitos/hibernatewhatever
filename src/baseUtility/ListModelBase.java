package baseUtility;

import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;

public class ListModelBase<T> extends AbstractListModel<T> {

    private List<T> liste = new ArrayList<>();
    
    @Override
    public int getSize() {
        return liste.size();
    }

    @Override
    public T getElementAt(int index) {
        return liste.get(index);
    }
    
    public void setListe(List<T> liste) throws Exception {
        this.liste = liste;
        super.fireContentsChanged(this, 0, liste.size()-1);
    }
    
    //todo: Model Operationen: delete, change usw.

    
    
}
