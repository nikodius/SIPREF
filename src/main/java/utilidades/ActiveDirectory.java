/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;

import java.util.Hashtable;
import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;

/**
 *
 * @author UserQV
 */
public class ActiveDirectory {

    static DirContext ldapContext;

    public static boolean UserAuth(String user, String psw) throws NamingException {
        boolean salida = false;
        try {
            Hashtable<String, String> ldapEnv = new Hashtable<String, String>(11);
            ldapEnv.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
            ldapEnv.put(Context.PROVIDER_URL, "ldap://169.254.60.40:389");
            ldapEnv.put(Context.SECURITY_AUTHENTICATION, "simple");
            ldapEnv.put(Context.SECURITY_PRINCIPAL, user + "@yonimaja.server");
            ldapEnv.put(Context.SECURITY_CREDENTIALS, psw);
            ldapContext = new InitialDirContext(ldapEnv);

            SearchControls searchCtls = new SearchControls();

            String returnedAtts[] = {"sn", "givenName", "samAccountName"};
            searchCtls.setReturningAttributes(returnedAtts);

            searchCtls.setSearchScope(SearchControls.SUBTREE_SCOPE);
            String searchBase = "DC=yonimaja,DC=server";
            String searchFilter = "(objectClass=user)";
            SearchControls sCtrl = new SearchControls();
            sCtrl.setSearchScope(SearchControls.ONELEVEL_SCOPE);

            NamingEnumeration answer = ldapContext.search(searchBase, searchFilter, sCtrl);

            boolean pass = false;
            if (answer.hasMoreElements()) {
                pass = true;
            }

            if (pass) {
                salida = true;
            } else {
                salida = false;
            }
            ldapContext.close();
        } catch (Exception e) {
            System.out.println("Error de autenticacion: " + e.getMessage());
            salida = false;
        }
        return salida;
    }
}
