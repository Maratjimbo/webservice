<#import "parts/common.ftl" as c>

<@c.page>
    <form action="/editArticleOnce" method="post" >
        <div class="form-group">
            <input type="text" class="form-control" name="title" placeholder="Введите новое название статьи"/>
        </div>
        <div class="form-group">
            <input type="text" class="form-control" name="tag" placeholder="Введите новые ключевые слова"/>
        </div>
        <div class="form-group">
            <input type="text" class="form-control" name="date" placeholder="Введите новый год написания статьи"/>
        </div>
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <input type="hidden" class="form-control" name="message_id" value="${message_id}"/>
        <div class="form-group">
            <button type="submit" class="btn btn-primary">Изменить</button>
        </div>
        <#if message_id??>
            <div class="form-group">
                ${message_id?if_exists}
            </div>
        </#if>
    </form>

</@c.page>