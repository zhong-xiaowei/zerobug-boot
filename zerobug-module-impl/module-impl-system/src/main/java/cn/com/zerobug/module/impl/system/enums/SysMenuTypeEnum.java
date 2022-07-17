package cn.com.zerobug.module.impl.system.enums;

/**
 * @author zhongxiaowei
 * @date 2022/4/18
 */
public enum SysMenuTypeEnum {

    /**
     * 目录
     */
    DIRECTORY("目录", 1),
    /**
     * 菜单
     */
    MENU("菜单", 2),
    /**
     * 按钮
     */
    BUTTON("按钮", 3);;

    private String  desc;
    private Integer type;

    SysMenuTypeEnum(String desc, Integer type) {
        this.desc = desc;
        this.type = type;
    }

    public String getDesc() {
        return desc;
    }

    public Integer getType() {
        return type;
    }

    public static SysMenuTypeEnum of(Integer type) {
        for (SysMenuTypeEnum sysMenuTypeEnum : SysMenuTypeEnum.values()) {
            if (sysMenuTypeEnum.getType().equals(type)) {
                return sysMenuTypeEnum;
            }
        }
        return null;
    }

    /**
     * 是目录
     */
    public boolean isDirectory() {
        return this.type.equals(SysMenuTypeEnum.DIRECTORY.getType());
    }

    /**
     * 是菜单
     */
    public boolean isMenu() {
        return this.type.equals(SysMenuTypeEnum.MENU.getType());
    }

}
