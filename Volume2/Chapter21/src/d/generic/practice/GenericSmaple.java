package d.generic.practice;

import java.io.Serializable;

public class GenericSmaple {
    public static void main(String[] args) {
        GenericSmaple sample = new GenericSmaple();
        sample.checkCastingDto();
    }

    public void checkCastingDto() {
        CastingDTO dto1 = new CastingDTO();
        dto1.setObject(new String());

        CastingDTO dto2 = new CastingDTO();
        dto2.setObject(new StringBuffer());

        CastingDTO dto3 = new CastingDTO();
        dto3.setObject(new StringBuilder());

        CastingDTO2<String> dto4 = new CastingDTO2<String>();
        dto4.setObject(new String());

        CastingDTO2<StringBuffer> dto5 = new CastingDTO2<StringBuffer>();
        dto5.setObject(new StringBuffer());
        /**
         * 여기서 type을 getObject를 해보면 Object type이므로 형변환이 필요하다. 하지만 어떤 타입인지 instanceOf와 if문으로 검증하는 것은 비효율적
         *
         */
    }
}


class CastingDTO implements Serializable {
    private Object object;

    public void setObject(Object object) {
        this.object = object;
    }

    public Object getObject() {
        return object;
    }
}

class CastingDTO2<T> implements Serializable {
    private T object;
    public void setObject(T object) {
        this.object = object;
    }
    public T getObject() {
        return object;
    }
}