package com.toin.glp.models;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hb on 16/9/18.
 */
public class CompanyMemberInfo {
    public List<Identitys> identitys = new ArrayList<>();
    public long            createTime;
    public int             status;
    public int             memberType;
    public long            activeTime;
    public String          memberId;
    public String          companyName;
    public String          licenseNo;
    public String          organizationNo;
    public String          taxNo;
    public String          address;
    public String          legalPerson;
    public String          legalPersonPhone;
    public String          scale;
    public String          businessScope;
    public String          telephone;
    public String          contactName;
    public String          contactPhone;
    public String          extend;
    public int             lockStatus;

    public CompanyMemberInfo parse(JSONObject object) {
        JSONArray identityList = object.getJSONArray("identitys");
        for (int i = 0; i < identityList.size(); i++) {
            Identitys item = new Identitys();
            JSONObject obj = identityList.getJSONObject(i);
            item.parse(obj);
            identitys.add(item);
        }
        scale = object.getString("scale");
        createTime = object.getLong("createTime");
        status = object.getInteger("status");
        memberType = object.getInteger("memberType");
        activeTime = object.getLong("activeTime");
        memberId = object.getString("memberId");
        companyName = object.getString("companyName");
        licenseNo = object.getString("licenseNo");
        organizationNo = object.getString("organizationNo");
        taxNo = object.getString("taxNo");
        address = object.getString("address");
        legalPerson = object.getString("legalPerson");
        legalPersonPhone = object.getString("legalPersonPhone");
        businessScope = object.getString("businessScope");
        telephone = object.getString("telephone");
        contactName = object.getString("contactName");
        contactPhone = object.getString("contactPhone");
        extend = object.getString("extend");
        lockStatus = object.getInteger("lockStatus");
        return this;
    }

    class Identitys {
        public String identity;
        public int    identityType;
        public String platformType;

        public Identitys parse(JSONObject object) {
            identity = object.getString("identity");
            identityType = object.getInteger("identityType");
            platformType = object.getString("platformType");
            return this;
        }

    }
}
