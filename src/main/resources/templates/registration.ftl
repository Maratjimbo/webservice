<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page>
Регистрация нового пользователя
    <br/>${message?ifExists}<br/>
<@l.login "/registration" true/>
</@c.page>