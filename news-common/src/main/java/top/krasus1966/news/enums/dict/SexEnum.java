package top.krasus1966.news.enums.dict;

/**
 * 性别enum
 *
 * @author Krasus1966
 * @date 2020/10/28 23:10
 **/
public enum SexEnum {

    /**
     * 性别
     */
    MAN(0,"男"),
    WOMAN(1,"女"),
    SECRET(2,"秘密"),
    ;


    public final Integer type;
    public final String value;

    SexEnum (Integer type,String value){
        this.type = type;
        this.value = value;
    }
}
