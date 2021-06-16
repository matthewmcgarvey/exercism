#lang racket
(provide my-reverse)

(define (my-reverse s)
  (define (helper l acc)
    (if (empty? l)
      acc
      (helper (cdr l) (cons (car l) acc))))
  (list->string (helper (string->list s) '())))
