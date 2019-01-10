<#import "parts/common.ftl" as c>

<@c.page>
    <h3>${title?ifExists}</h3>
    <div class="form-group mt-2">
        <br/>Автор: ${author?ifExists}<br/>
    </div>
    <div class="form-group mt-2">
        <br/>Год написания: ${date?ifExists}<br/>
    </div>
    <div>
        <br/>Ключевые слова:
        <#if words??>
            <#list words as word>
                <br/>${word?ifExists}
            </#list>
        <#else>
            Пока что список пуст
        </#if>
    </div>
    <div>
    <#if file??>
        <object data="/img/${file?ifExists}" type="application/x-pdf" title="SamplePdf" width="500" height="720">
        <a href="/img/${file?ifExists}" target="_blank">Просмотреть статью</a>
        </object>
     </#if>
    </div>
</@c.page>