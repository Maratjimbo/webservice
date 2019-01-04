<#import "parts/common.ftl" as c>

<@c.page>
    <#if articles??>
        <div class="card-columns">
        <#list articles as article>
            <div class="card my-3">
            <div class="m-2">
            <span>${article.title}</span>
            </div>
            <div class="card-footer text-muted">
        Автор статьи : ${article.authorName}
            </div>
            <form class="form-inline" method="post" action="/showArticle">
                <input type="hidden" value="${article.id}" name="id" />
                <input type="hidden" value="${_csrf.token}" name="_csrf" />
                <button type="submit" class="btn btn-primary mt-2">Просмотреть</button>
            </form>
            <form class="form-inline" method="post" action="/allArticle">
                <input type="hidden" value="${article.id}" name="id" />
                <input type="hidden" value="${_csrf.token}" name="_csrf" />
                <button type="submit" class="btn btn-primary mt-2">Удалить</button>
            </form>
            </div>
        </#list>
        </div>
    </#if>

    <#if message??>
        <div class="form-group">
        <br/>${message?if_exists}<br/>
        </div>
    </#if>
</@c.page>