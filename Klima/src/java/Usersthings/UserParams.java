/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usersthings;

import DBEntities.Userroles;
import DBEntities.Users;
import Filters.MenuItem;
import SessionBeans.UsersFacade;
import SessionBeans.UserrolesFacade;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
//import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Gery
 */
@ManagedBean(name = "userparams")
@SessionScoped
public class UserParams implements Serializable {

    private List<MenuItem> menulist;
    private static final Logger LOG = Logger.getLogger(UserParams.class.getName());

    private String username;
    private String userrole;
    private String password;
    private String msg;
    @Inject
    UserrolesFacade urf;
    @Inject
    UsersFacade uf;

    public UserParams() {
        //LOG.info("konstruktor***************************"+SessionUtil.getSession().getId());        
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserrole() {
        return userrole;
    }

    public void setUserrole(String userrole) {
        this.userrole = userrole;
    }

    public String Login() {
        if (username.equals("") || password.equals("")) {
            msg = "Kérem adja meg az adatait";
            return "login";
        }
        Sha256 s = new Sha256(getPassword());
        String shapsw = s.getSha256();
        Users u = uf.findUser(getUsername());
        if (u.getPasswd() != null && !u.getPasswd().equals("")) {
            if (u.getPasswd().equals(shapsw)) {
                Userroles ur = urf.findUserRole(getUsername());
                setUserrole(ur.getRole());
                setPassword("");
                HttpSession session = SessionUtil.getSession();
                session.setAttribute("username", getUsername());
                session.setAttribute("userrole", getUserrole());
                setupMenu();
                msg = "";
                return "root/mainpage";
            } else {
                msg = "Jelszó helytelen";
            }
        } else {
            msg = "Nincs ilyen felhasználó";
        }

        return "Login";
    }

    public String Logout() {
        HttpSession session = SessionUtil.getSession();
        session.invalidate();
        return "login";
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the msg
     */
    public String getMsg() {
        return msg;
    }

    /**
     * @param msg the msg to set
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * @return the menulist
     */
    public List<MenuItem> getMenulist() {
        return menulist;
    }

    /**
     * @param menulist the menulist to set
     */
    public void setMenulist(List<MenuItem> menulist) {
        this.menulist = menulist;
    }

    private void setupMenu() {
        menulist = new ArrayList<MenuItem>();
        if (userrole.equals("admin")) {
            menulist.add(new MenuItem("Raktar", "raktar"));
            menulist.add(new MenuItem("Vevők", "vevo"));
            menulist.add(new MenuItem("Megrendelések", "megrendeles"));            
            menulist.add(new MenuItem("Készülékek kezelés", "keszulekek"));            
            menulist.add(new MenuItem("Raktárak készülékei", "raktarkeszulekek"));
            menulist.add(new MenuItem("Raktár megrendelések", "raktarrarendeles"));
            menulist.add(new MenuItem("Felhasználó kezelés", "usermanagement"));
        } else if (userrole.equals("elado")) {
            menulist.add(new MenuItem("Vevők", "vevo"));            
        } else if (userrole.equals("raktar")) {
            menulist.add(new MenuItem("Raktar", "raktar"));
            menulist.add(new MenuItem("Készülékek kezelés", "keszulekek"));
            menulist.add(new MenuItem("Raktárak készülékei", "raktarkeszulekek"));
            menulist.add(new MenuItem("Raktár megrendelések", "raktarrarendeles"));
        }
    }
}
