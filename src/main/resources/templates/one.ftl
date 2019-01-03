<#import "parts/common.ftl" as c>

<@c.page>
    <h5>${title?ifExists}</h5>
    <div class="container mt-2">
        <br/>Автор: ${author?ifExists}<br/>
    </div>
    <div class="container mt-2">
        <br/>Текст: ${text?ifExists}<br/>
    </div>
</@c.page>