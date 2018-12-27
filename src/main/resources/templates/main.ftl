<#import "parts/common.ftl" as c>

<@c.page>
    <div class="form-row" xmlns="http://www.w3.org/1999/html" xmlns="http://www.w3.org/1999/html">
    <div class="form-group col-md-6">
    <form method="get" action="/main" class="form-inline">
    <input type="text" name="filter" class="form-control" value="${filter?ifExists}" placeholder="Поиск по тэгу">
<button type="submit" class="btn btn-primary ml-2">Поиск</button>
    </form>
    </div>
    <div class="form-group col-md-6">
    <form method="get" action="/main" class="form-inline">
<input type="text" name="username" class="form-control" value="${username?ifExists}" placeholder="Поиск по имени">
    <button type="submit" class="btn btn-primary ml-2">Поиск</button>
    </form>
    </div>
    </div>

    <a class="btn btn-primary" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
        Добавить новое сообщение
    </a>
    <div class="collapse" id="collapseExample">
    <div class="form-group mt-3">
    <form method="post" enctype="multipart/form-data">
    <div class="form-group">
        <input type="text" class="form-control" name="text" placeholder="Введите сообщение" />
    </div>
    <div class="form-group">
        <input type="text" class="form-control" name="tag" placeholder="Тэг">
    </div>
    <div class="form-group">
        <div class="custom-file">
            <input type="file" name="file" id="customFile">
            <label class="custom-file-label" for="customFile">Choose file</label>
        </div>
    </div>
    <input type="hidden" name="_csrf" value="${_csrf.token}" />
    <div class="form-group">
        <button type="submit" class="btn btn-primary">Добавить</button>
    </div>
    </form>
    </div>
    </div>
    <div class="card-columns">
    <#list messages as message>
        <div class="card my-3">
        <div class="m-2">
        <span>${message.text}</span>
        <i>${message.tag}</i>
        </div>
        <div class="card-footer text-muted">
        ${message.authorName}
        </div>
        <form class="form-inline" action="/deleteMessage">
        <input type="hidden" value="${message.id}" name="id">
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <button type="submit" class="btn btn-outline-success my-2 my-sm-0">Удалить</button>
        </form>

        </div>
    <#else>
        Пока что список пуст
    </#list>
    </div>
</@c.page>