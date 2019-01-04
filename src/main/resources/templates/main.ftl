<#import "parts/common.ftl" as c>

<@c.page>

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
        </div>

    <#else>
        Пока что список пуст
    </#list>
    </div>
</@c.page>