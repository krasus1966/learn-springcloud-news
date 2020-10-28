package top.krasus1966.news.enums.dict;

/**
 * 状态enum
 *
 * @author Krasus1966
 * @date 2020/10/28 23:14
 **/
public enum  StatusEnum {

    /**
     * 全局启用禁用状态，包括逻辑删除
     */
    STATUS_ON(0,"启用"),
    STATUS_OFF(1,"禁用")
    ;

    public final Integer type;
    public final String value;

    StatusEnum (Integer type,String value){
        this.type = type;
        this.value = value;
    }
}
