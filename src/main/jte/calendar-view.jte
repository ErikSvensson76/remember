@import org.example.remember.model.dto.Pair
@import org.example.remember.model.dto.ViewDate
@import java.time.LocalDate
@import java.util.List
@param List<Pair<Integer, List<ViewDate>>> dates
@param String title
@param int year
@param int month

<!doctype html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="webjars/bootstrap/5.3.3/css/bootstrap.min.css">
    <title>${title}</title>
</head>
<body>
<div class="container">
    <div class="card bg-white">
        <div class="card-header">
            <div class="row align-content-between align-items-center text-center">
                <a class="col-2 btn btn-primary" href="/calendar?year=${month == 1 ? year - 1 : year}&month=${month == 1 ? 12 : month - 1}">Föregående</a>
                <h5  class="col card-title">${title}</h5>
                <a class="col-2 btn btn-primary" href="/calendar?year=${month == 12 ? year + 1 : year}&month=${month == 12 ? 1 : month + 1}">Nästa</a>
            </div>
        </div>

        <div class="card-body row-cols-sm-auto">
            <div class="card-group shadow-lg">
                <div class="card border-0" style="width: 14rem;">
                    <div class="card-body" style="border-bottom: 1px solid black; border-right: 1px solid black">
                        <h6 class="card-title text-body-secondary text-center bold mb-0 mt-0"><strong>Vecka</strong></h6>
                    </div>
                </div>
                <div class="card border-0" style="width: 14rem; ">
                    <div class="card-body" style="border-bottom: 1px solid black;">
                        <h6 class="card-title text-body-secondary text-center bold">Måndag</h6>
                    </div>
                </div>
                <div class="card border-0" style="width: 14rem;">
                    <div class="card-body" style="border-bottom: 1px solid black;">
                        <h6 class="card-title text-body-secondary text-center bold">Tisdag</h6>
                    </div>
                </div>
                <div class="card border-0" style="width: 14rem;">
                    <div class="card-body" style="border-bottom: 1px solid black;">
                        <h6 class="card-title text-body-secondary text-center bold">Onsdag</h6>
                    </div>
                </div>
                <div class="card border-0" style="width: 14rem;">
                    <div class="card-body" style="border-bottom: 1px solid black;">
                        <h6 class="card-title text-body-secondary text-center bold">Torsdag</h6>
                    </div>
                </div>
                <div class="card border-0" style="width: 14rem;">
                    <div class="card-body" style="border-bottom: 1px solid black;">
                        <h6 class="card-title text-body-secondary text-center bold">Fredag</h6>
                    </div>
                </div>
                <div class="card border-0" style="width: 14rem;">
                    <div class="card-body" style="border-bottom: 1px solid black;">
                        <h6 class="card-title text-body-secondary text-center bold">Lördag</h6>
                    </div>
                </div>
                <div class="card border-0" style="width: 14rem;">
                    <div class="card-body" style="border-bottom: 1px solid black;">
                        <h6 class="card-title text-body-secondary text-center bold">Söndag</h6>
                    </div>
                </div>
            </div>
                @for(Pair<Integer, List<ViewDate>> pair : dates)
                    <div class="card-group shadow-lg">
                        <div class="card border-0" style="width: 14rem;">
                            <div class="card-body" style="border-right: 1px solid black;">
                                <h6 class="card-title text-body-secondary text-center bold">${pair.key()}</h6>
                            </div>
                        </div>
                        @for(ViewDate viewDate : pair.value())
                            @if(month == viewDate.getMonth())
                                @if(LocalDate.of(viewDate.getYear(),viewDate.getMonth(), viewDate.getDate().getDayOfMonth()).equals(LocalDate.now()))
                                    <div class="card border-0 bg-success-subtle" style="width: 14rem;">
                                        <div class="card-body" style="border-right: 1px solid gainsboro;">
                                            <h6 class="card-title text-body-secondary text-center bold">${viewDate.getDayOfWeek()}</h6>
                                        </div>
                                    </div>
                                @else
                                    <div class="card border-0" style="width: 14rem;">
                                        <div class="card-body" style="border-right: 1px solid gainsboro;">
                                            <h6 class="card-title text-body-secondary text-center bold">${viewDate.getDayOfWeek()}</h6>
                                        </div>
                                    </div>
                                @endif
                                @else
                                <div class="card border-0" style="width: 14rem;">
                                    <div class="card-body bg-dark-subtle" style="border-right: 1px solid gainsboro;">
                                        <h6 class="card-title text-body-secondary text-center bold">${viewDate.getDayOfWeek()}</h6>
                                    </div>
                                </div>
                            @endif
                        @endfor
                    </div>
                @endfor
        </div>
    </div>
</div>
<script src="webjars/bootstrap/5.3.3/js/bootstrap.bundle.min.js"></script>
</body>
</html>