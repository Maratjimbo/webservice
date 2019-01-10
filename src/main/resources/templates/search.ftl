<#import "parts/common.ftl" as c>

<@c.page>
    <form action="/search" method="get">
    <div class="form-group">
        <h4>Поиск по автору</h4>
        <input type="text" class="form-control" name="authorName" value="${authorName?if_exists}" placeholder="Введите автора"/>
        <button type="submit" class="btn btn-primary mt-2">Поиск</button>
    </div>
    <div class="form-group">
        <h4>Поиск по ключевому слову</h4>
        <input type="text" class="form-control" name="word" value="${word?if_exists}" placeholder="Введите ключевое слово"/>
        <button type="submit" class="btn btn-primary mt-2">Поиск</button>
    </div>
    <div class="form-group">
        <h4>Поиск по названию</h4>
        <input type="text" class="form-control" name="title" value="${title?if_exists}" placeholder="Введите название"/>
        <button type="submit" class="btn btn-primary mt-2">Поиск</button>
    </div>
    <div class="form-group">
        <h4>Поиск по году написания</h4>
        <input type="text" class="form-control" name="date" value="${date?if_exists}" placeholder="Введите год написания"/>
        <button type="submit" class="btn btn-primary mt-2">Поиск</button>
    </div>
    </form>

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
        </div>
    </#list>
    </div>
    </#if>

    <#if message??>
        <div class="form-group" id="message-id">
            ${message?if_exists}
        </div>
    </#if>


</@c.page>