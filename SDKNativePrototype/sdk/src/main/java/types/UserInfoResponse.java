package types;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserInfoResponse extends TypeResponse{
    private Map<String, Map<String, String>> info;

    //  Constructor
    public UserInfoResponse(JSONObject infoJSON, List<String> scope) throws JSONException {
        super(true);
        info = new HashMap<String, Map<String, String>>();
        for(String scopeD : scope){
            Map<String,String> scopeInfo = new HashMap<String,String>();
            switch(scopeD) {
                case "openid":
                    scopeInfo.put("sub", infoJSON.getString("sub"));
                    break;
                case "personal_info":
                    scopeInfo.put("nombre_completo", infoJSON.getString("nombre_completo"));
                    scopeInfo.put("primer_nombre", infoJSON.getString("primer_nombre"));
                    scopeInfo.put("segundo_nombre", infoJSON.getString("segundo_nombre"));
                    scopeInfo.put("primer_apellido", infoJSON.getString("primer_apellido"));
                    scopeInfo.put("segundo_apellido", infoJSON.getString("segundo_apellido"));
                    scopeInfo.put("uid", infoJSON.getString("uid"));
                    scopeInfo.put("rid", infoJSON.getString("rid"));
                    break;
                case "profile":
                    scopeInfo.put("name", infoJSON.getString("name"));
                    scopeInfo.put("given_name", infoJSON.getString("given_name"));
                    scopeInfo.put("family_name", infoJSON.getString("family_name"));
                    break;
                case "email":
                    scopeInfo.put("email", infoJSON.getString("email"));
                    scopeInfo.put("email_verified", infoJSON.getString("email_verified"));
                    break;
                case "document":
                    scopeInfo.put("pais_documento", infoJSON.getString("pais_documento"));
                    scopeInfo.put("tipo_documento", infoJSON.getString("tipo_documento"));
                    scopeInfo.put("numero_documento", infoJSON.getString("numero_documento"));
                    break;
                case "auth_info":
                    scopeInfo.put("rid", infoJSON.getString("rid"));
                    scopeInfo.put("nid", infoJSON.getString("nid"));
                    scopeInfo.put("ae", infoJSON.getString("ae"));
                    break;
            }
            info.put(scopeD,scopeInfo);

        }
    }

    //  Getter & Setter for info
    public Map<String, Map<String, String>> getInfo() {
        return info;
    }

    public void setInfo(Map<String, Map<String, String>> info) {
        this.info = info;
    }
}
