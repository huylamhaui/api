package lamph11.api.service;

import org.springframework.data.mongodb.core.query.Criteria;

public class CategoryTypeCriteria {

    public static Criteria nameLike(String name) {
        String regex = "/" + name + "/";
        return Criteria.where("name").regex(regex);
    }

    public static Criteria nameEqual(String name) {
        return Criteria.where("name").is(name);
    }

    public static Criteria codeLike(String code) {
        String regex = "/" + code + "/";
        return Criteria.where("code").regex(regex);
    }

    public static Criteria codeEqual(String code) {
        return Criteria.where("code").is(code);
    }
}
