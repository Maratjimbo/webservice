<#import "parts/common.ftl" as c>

<@c.page>
    <form action="/article" method="post" enctype="multipart/form-data">
        <div class="form-group">
            <input type="text" class="form-control" name="title" placeholder="Введите название статьи">
        </div>
        <div class="form-group">
            <input type="text" class="form-control" name="tag" placeholder="Введите ключевые слова">
         </div>
        <div class="form-group">
            <input type="text" class="form-control" name="date" placeholder="Введите год написания статьи">
        </div>
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <div class="form-group">
            <input type="file" name="file">
        </div>
         <div class="form-group">
                <button type="submit" class="btn btn-primary">Добавить</button>
         </div>
    </form>

</@c.page>