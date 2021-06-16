#lang racket

(provide rebase)

(define (to-out-base base-10 out-base)
  (define (convert-base b10)
    (let-values ([(result remainder) (quotient/remainder b10 out-base)])
      (if (zero? result)
          (cons remainder '())
          (cons remainder (convert-base result)))))
  (reverse (convert-base base-10)))

(define (rebase list-digits in-base out-base)
  (define (to-base-10 lds)
    (if (empty? lds)
        0
        (+ (* (car lds) (expt in-base (length (cdr lds)))) (to-base-10 (cdr lds)))))
  (define (invalid-digit? digit)
    (or (>= digit in-base) (< digit 0)))
  (if (or (<= in-base 1) (<= out-base 1) (not (empty? (filter invalid-digit? list-digits))))
    false
    (to-out-base (to-base-10 list-digits) out-base)))

