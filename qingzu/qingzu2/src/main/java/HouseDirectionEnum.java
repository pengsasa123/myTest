import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum HouseDirectionEnum {
    EAST(1, "东"),
    SOUTH(2, "南"),
    WEST(3, "西"),
    NORTH(4, "北"),
    SOUTHEAST(5, "东南"),
    NORTHEAST(6, "东北"),
    SOUTHWEST(7, "西南"),
    NORTHWEST(8, "西北"),
    ;

    private int code;
    private String name;

    public static HouseDirectionEnum from(Integer code) {
        if (code == null) {
            return null;
        }
        for (HouseDirectionEnum e : HouseDirectionEnum.values()) {
            if (e.code == code) {
                return e;
            }
        }
        return null;
    }

    public static String getNameByCode(Integer code) {
        HouseDirectionEnum e = from(code);
        return e == null ? "" : e.getName();
    }
}
