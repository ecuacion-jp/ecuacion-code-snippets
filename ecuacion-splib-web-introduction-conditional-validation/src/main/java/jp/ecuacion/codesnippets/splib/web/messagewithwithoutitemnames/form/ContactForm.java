package jp.ecuacion.codesnippets.splib.web.messagewithwithoutitemnames.form;

import jakarta.validation.constraints.NotEmpty;
import jp.ecuacion.lib.validation.constraints.NotEmptyWhen;
import jp.ecuacion.lib.validation.constraints.NotEmptyWhen.ConditionValue;

@NotEmptyWhen(
    propertyPath = "email",
    conditionPropertyPath = "wantsResponse",
    conditionValue = ConditionValue.TRUE,
    message = "返信希望の場合はメールアドレスは必須です。"
)
public class ContactForm {

    @NotEmpty
    private String name;

    private boolean wantsResponse;

    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isWantsResponse() {
        return wantsResponse;
    }

    public void setWantsResponse(boolean wantsResponse) {
        this.wantsResponse = wantsResponse;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
