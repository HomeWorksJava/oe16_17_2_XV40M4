/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vm;

import java.util.List;

public abstract class BaseVM<T> {
    protected T ujItem;
    protected T keresendoItem;
    protected List<T> keresettItems;
    protected List<T> ListedItems;
    protected boolean edit;
    public BaseVM(){}
    public abstract List<T> getfindAll();
    public abstract void EditItem(T t);
    public abstract void SaveEdit();
    public abstract void AddNewItem();
    public abstract void CancelEdit();
    public abstract void DeleteItem(T t);
    public abstract void Kereses();

    /**
     * @return the ujItem
     */
    public T getUjItem() {
        return ujItem;
    }

    /**
     * @param ujItem the ujItem to set
     */
    public void setUjItem(T ujItem) {
        this.ujItem = ujItem;
    }

    /**
     * @return the keresendoItem
     */
    public T getKeresendoItem() {
        return keresendoItem;
    }

    /**
     * @param keresendoItem the keresendoItem to set
     */
    public void setKeresendoItem(T keresendoItem) {
        this.keresendoItem = keresendoItem;
    }

    /**
     * @return the keresettItems
     */
    public List<T> getKeresettItems() {
        return keresettItems;
    }

    /**
     * @param keresettItems the keresettItems to set
     */
    public void setKeresettItems(List<T> keresettItems) {
        this.keresettItems = keresettItems;
    }

    /**
     * @return the ListedItems
     */
    public List<T> getListedItems() {
        return ListedItems;
    }

    /**
     * @param ListedItems the ListedItems to set
     */
    public void setListedItems(List<T> ListedItems) {
        this.ListedItems = ListedItems;
    }

    /**
     * @return the edit
     */
    public boolean isEdit() {
        return edit;
    }

    /**
     * @param edit the edit to set
     */
    public void setEdit(boolean edit) {
        this.edit = edit;
    }
}
