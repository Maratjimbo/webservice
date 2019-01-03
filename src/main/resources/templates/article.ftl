<#import "parts/common.ftl" as c>

<@c.page>
    <form action="/article" method="post">
        <div class="form-group">
            <input type="text" class="form-control" name="title" placeholder="Введите название статьи">
        </div>
        <div class="form-group">
            <input type="text" class="form-control" name="text" placeholder="Введите статью" />
        </div>
        <div class="form-group">
            <input type="text" class="form-control" name="tag" placeholder="Введите ключевые слова">
         </div>
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
         <div class="form-group">
                <button type="submit" class="btn btn-primary">Добавить</button>
         </div>
    </form>


    <div class="card-columns">
    <#list articles as article>
        <div class="card my-3">
            <div class="m-2">
                <span>${article.title}</span>
            </div>
            <div class="card-footer text-muted">
                Автор статьи : ${article.authorName}
            </div>
        </div>
    <#else>
        Пока что список пуст
    </#list>
    </div>

</@c.page>