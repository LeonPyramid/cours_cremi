StackExchange.postValidation=function(){function e(e,t,n){var i={"Title":".js-post-title-field","Body":".js-post-body-field[data-post-type-id="+t+"]","Tags":".js-post-tags-field","Mentions":".js-post-mentions-field","EditComment":".js-post-edit-comment-field","Excerpt":".js-post-excerpt-field","Email":".js-post-email-field","ArticleType":".js-article-type-field"};return i[n]?e.find(i[n]):$()}function t(t,n,i){var r=e(t,n,i);return i===L||i===D?t.find(".js-tag-editor").filter(function(){return $(this).data("target-field")===r.get(0)}):r}function n(e,t,n,i){var r=e.find('input[type="submit"]:visible, button[type="submit"]:visible'),a=r.length&&r.is(":enabled");a&&r.prop("disabled",!0),l(e,t,n),u(e,t,n,i),p(e,t,n),h(e,t,n),g(e,t,n),x(e,t,function(){d(e,t,n),a&&r.prop("disabled",!1)})}function i(i,s,c,l,u){n(i,s,c,l);var d,p=function(e){if(i.trigger("post:submit-completed",[{"formType":c,"postTypeId":s,"response":e}]),e.success)if(u)u(e);else{var t=window.location.href.split("#")[0],n=e.redirectTo.split("#")[0];0===n.indexOf("/")&&(n=window.location.protocol+"//"+window.location.hostname+n),d=!0,window.location=e.redirectTo,t.toLowerCase()===n.toLowerCase()&&window.location.reload(!0)}else e.captchaHtml?StackExchange.nocaptcha.init(e.captchaHtml,p):e.errors?(i.find(".js-post-prior-attempt-count").val(function(e,t){return(+t+1||0).toString()}),w(i,s,c,e.errors,e.warnings)):b(i,s,c,{"General":[$("<span/>").text(e.message).html()]},0)};i.submit(function(){if(i.find(".js-post-answer-while-asking-checkbox").is(":checked"))return!0;if(f(i,s,c))return StackExchange.helpers.enableSubmitButton(i),!1;if(o(),StackExchange.navPrevention&&StackExchange.navPrevention.stop(),i.find('input[type="submit"]:visible, button[type="submit"]').addClass("is-loading"),StackExchange.helpers.disableSubmitButton(i),StackExchange.options.site.enableNewTagCreationWarning){var n=e(i,s,L),l=n.prop("defaultValue");if(n.val()!==l)return $.ajax({"type":"GET","url":"/posts/new-tags-warning","dataType":"json","data":{"tags":n.val()},"success":function(e){if(e.showWarning){var n={"closeOthers":!0,"shown":function(){$(".js-confirm-tag-creation").on("click",function(e){return StackExchange.helpers.closePopups(),a(i,s,c,d,p),e.preventDefault(),!1})},"dismissing":function(){r(i,d)},"returnElements":t(i,s,L).find("input:visible")};StackExchange.helpers.showModal($(e.html).elementNodesOnly(),n),StackExchange.helpers.bindMovablePopups()}else a(i,s,c,d,p)}}),!1}return setTimeout(function(){a(i,s,c,d,p)},0),!1})}function r(e,t){e.find('input[type="submit"]:visible, button[type="submit"]').removeClass("is-loading"),t||StackExchange.helpers.enableSubmitButton(e)}function a(e,t,n,i,a){$.ajax({"type":"POST","dataType":"json","data":e.serialize(),"url":e.attr("action"),"success":a,"error":function(){var i=v(n,0);b(e,t,n,{"General":[$("<span/>").text(i).html()]},0)},"complete":function(){r(e,i)}})}function o(){for(var e=0;e<z.length;e++)clearTimeout(z[e]);z=[]}function s(t,n,i,r,a){e(t,n,r).blur(function(){var e=this,o=$(this),s=function(e){E(t,n,i,r,e)},c=function(e){return k(e,t,n,i,[r])};z.push(setTimeout(function(){var t=StackExchange.stacksValidation.handlerFor(o);t&&!M&&t.clear(),a.call(e,o,s,c)},V))})}function c(t,n,i,r,a){if(1===n)return k({"type":"POST","url":"/posts/validate-question","data":{"title":e(t,n,N).val(),"body":e(t,n,P).val(),"tags":e(t,n,L).val(),"fkey":StackExchange.options.user.fkey}},t,n,i,[N,P,L],a).promise();if(2===n)return k({"type":"POST","url":"/posts/validate-body","data":{"body":e(t,n,P).val(),"oldBody":e(t,n,P).prop("defaultValue"),"isQuestion":!1,"isSuggestedEdit":r||!1,"fkey":StackExchange.options.user.fkey}},t,n,i,[P],a).promise();var o=$.Deferred();return o.reject(),o.promise()}function l(e,t,n){s(e,t,n,N,function(e,t,n){var i=e.val(),r=$.trim(i).length,a=e.data("min-length"),o=e.data("max-length");return 0!==r||M?a&&a>r?(t(function(e){return 1==e.minLength?"Title must be at least "+e.minLength+" character.":"Title must be at least "+e.minLength+" characters."}({"minLength":a})),void 0):o&&r>o?(t(function(e){return 1==e.maxLength?"Title cannot be longer than "+e.maxLength+" character.":"Title cannot be longer than "+e.maxLength+" characters."}({"maxLength":o})),void 0):(n({"type":"POST","url":"/posts/validate-title","data":{"title":i,"fkey":StackExchange.options.user.fkey}}),void 0):(t(),void 0)})}function u(e,t,n,i){s(e,t,n,P,function(e,n,r){var a=e.val(),o=$.trim(a).length,s=e.data("min-length");return 0!==o||M?5===t?(s&&s>o?n(function(e){return"Wiki Body must be at least "+e.minLength+" characters. You entered "+e.actual+"."}({"minLength":s,"actual":o})):n(),void 0):((1===t||2===t)&&r({"type":"POST","url":"/posts/validate-body","data":{"body":a,"oldBody":e.prop("defaultValue"),"isQuestion":1===t,"isSuggestedEdit":i,"fkey":StackExchange.options.user.fkey}}),void 0):(n(),void 0)})}function d(e,t,n){s(e,t,n,L,function(e,t,n){var i=e.val(),r=$.trim(i).length;return 0!==r||M?(n({"type":"POST","url":"/posts/validate-tags","data":{"tags":i,"oldTags":e.prop("defaultValue"),"fkey":StackExchange.options.user.fkey},"success":function(t){var n=e.closest(".js-post-form").find(".js-warned-tags-field");if(n.length){var i=n.val(),r=n.data("warned-tags")||[],a=((t.source||{}).Tags||[]).filter(function(e){return e&&-1===r.indexOf(e)});a.length>0&&StackExchange.using("gps",function(){a.forEach(function(e){StackExchange.gps.track("tag_warning.show",{"tag":e},!0),i+=" "+e,r.push(e)}),n.val($.trim(i)).data("warned-tags",r),StackExchange.gps.sendPending()})}}}),void 0):(t(),void 0)})}function f(t,n,i){return"[Edit removed during grace period]"===$.trim(e(t,n,R).val())?(E(t,n,i,R,"Comment reserved for system use. Please use an appropriate comment."),!0):!1}function p(e,t,n){s(e,t,n,R,function(i,r){var a=i.val(),o=$.trim(a).length,s=i.data("min-length"),c=i.data("max-length");return 0===o?(r(),void 0):s&&s>o?(r(function(e){return 1==e.minLength?"Your edit summary must be at least "+e.minLength+" character.":"Your edit summary must be at least "+e.minLength+" characters."}({"minLength":s})),void 0):c&&o>c?(r(function(e){return 1==e.maxLength?"Your edit summary cannot be longer than "+e.maxLength+" character.":"Your edit summary cannot be longer than "+e.maxLength+" characters."}({"maxLength":c})),void 0):(f(e,t,n)||r(),void 0)})}function h(e,t,n){s(e,t,n,B,function(e,t){var n=e.val(),i=$.trim(n).length,r=e.data("min-length"),a=e.data("max-length");return 0===i?(t(),void 0):r&&r>i?(t(function(e){return"Wiki Excerpt must be at least "+e.minLength+" characters; you entered "+e.actual+"."}({"minLength":r,"actual":i})),void 0):a&&i>a?(t(function(e){return"Wiki Excerpt cannot be longer than "+e.maxLength+" characters; you entered "+e.actual+"."}({"maxLength":a,"actual":i})),void 0):(t(),void 0)})}function g(e,t,n){s(e,t,n,U,function(e,t){var n=e.val(),i=$.trim(n),r=i.length;return 0===r?(t(),void 0):StackExchange.helpers.isEmailAddress(i)?(t(),void 0):(t("This email does not appear to be valid."),void 0)})}function m(e,t){var n=$("#sidebar, .sidebar").first().width()||270,i="lg"===StackExchange.responsive.currentRange();return e===q?{"position":"inline","css":{"display":"inline-block","margin-bottom":"10px"},"closeOthers":!1,"dismissable":!1,"type":t}:{"position":{"my":i?"left top":"top center","at":i?"right center":"bottom center"},"css":{"max-width":n,"min-width":n},"closeOthers":!1,"type":t}}function v(e,t){if(t>0)switch(e){case"question":return function(e){return 1==e.specificErrorCount?"Your question couldn't be submitted. Please see the error above.":"Your question couldn't be submitted. Please see the errors above."}({"specificErrorCount":t});case"answer":return function(e){return 1==e.specificErrorCount?"Your answer couldn't be submitted. Please see the error above.":"Your answer couldn't be submitted. Please see the errors above."}({"specificErrorCount":t});case"edit":return function(e){return 1==e.specificErrorCount?"Your edit couldn't be submitted. Please see the error above.":"Your edit couldn't be submitted. Please see the errors above."}({"specificErrorCount":t});case"tags":return function(e){return 1==e.specificErrorCount?"Your tags couldn't be submitted. Please see the error above.":"Your tags couldn't be submitted. Please see the errors above."}({"specificErrorCount":t});case"article":return function(e){return 1==e.specificErrorCount,"Your article couldn't be submitted. Please see the errors above."}({"specificErrorCount":t});default:return function(e){return 1==e.specificErrorCount?"Your post couldn't be submitted. Please see the error above.":"Your post couldn't be submitted. Please see the errors above."}({"specificErrorCount":t})}else switch(e){case"question":return"An error occurred submitting the question.";case"answer":return"An error occurred submitting the answer.";case"edit":return"An error occurred submitting the edit.";case"tags":return"An error occurred submitting the tags.";case"article":return"An error occurred submitting the article.";default:return"An error occurred submitting the post."}}function b(e,t,n,i,r){var a=e.find(".js-general-error").text("").removeClass("d-none");if(!_(e,a,i,null,q,t,n))return r>0?(a.text(v(n,r)),void 0):(a.addClass("d-none"),void 0)}function y(e){var t=$(".js-post-review-summary").closest(".js-post-review-summary-container");if(t.length>0)return t.filter(":visible").scrollIntoView(),void 0;var n;I()&&($("#sidebar").animate({"opacity":.4},500),n=setInterval(function(){I()||($("#sidebar").animate({"opacity":1},500),clearInterval(n))},500));var i;e.find(".validation-error, .js-stacks-validation.has-error").each(function(){var e=$(this).offset().top;(!i||i>e)&&(i=e)});var r=function(){for(var t=0;3>t;t++)e.find(".message").animate({"left":"+=5px"},100).animate({"left":"-=5px"},100)};if(i){var a=$(".review-bar").length;i=Math.max(0,i-(a?125:30)),$("html, body").animate({"scrollTop":i},r)}else r()}function w(e,t,n,i,r){i&&x(e,t,function(){var a=S(e,t,n,[N,P,L,D,R,B,U,F],i,r).length;b(e,t,n,i,a),y(e)})}function x(e,n,i){var r=function(){1!==n||t(e,n,L).length?i():setTimeout(r,250)};r()}function k(e,t,n,i,r,a){return $.ajax(e).then(function(e){return a?$.when(a()).then(function(){return e}):e}).done(function(e){S(t,n,i,r,e.errors,e.warnings)}).fail(function(){S(t,n,i,r,{},{})})}function S(e,n,i,r,a,o){for(var s=[],c=0;c<r.length;c++){var l=r[c];_(e,t(e,n,l),a,o,l,n,i)&&s.push(l)}return s}function E(e,n,i,r,a){C(e,t(e,n,r),a?[$("<span/>").text(a).html()]:[],[],r,n,i)}function _(e,t,n,i,r,a,o){var s=n[r]||[],c=(i||{})[r]||[];return C(e,t,s,c,r,a,o)}function C(e,t,n,i,r,a,o){var s=StackExchange.stacksValidation.handlerFor(t);return s?j(s,a,o,n,i,r):T(t,r,n),e.find(".validation-error, .js-stacks-validation.has-error").length||e.find(".js-general-error").text(""),t.trigger("post:validated-field",[{"errors":n,"warnings":i,"field":r,"postTypeId":a,"formType":o}]),n.length>0}function j(e,t,n,i,r){e.clear("error"),i.forEach(function(t){e.add("error",t)}),"edit"===n||"question"===n&&M||(e.clear("warning"),r.forEach(function(t){e.add("warning",t)}))}function T(e,t,n){e&&e.length&&(0===n.length||1===n.length&&""===n[0]||!$("html").has(e).length?A(e):O(e,n,m(t,"error")))}function O(e,t,n){var i=1===t.length?t[0]:"<ul><li>"+t.join("</li><li>")+"</li></ul>",r=e.data("error-popup");if(r&&r.is(":visible")){var a=e.data("error-message");if(a===i)return r.animateOffsetTop&&r.animateOffsetTop(0),void 0;r.fadeOutAndRemove()}var s=StackExchange.helpers.showMessage(e,i,n);s.find("a").attr("target","_blank"),s.click(o),e.addClass("validation-error").data("error-popup",s).data("error-message",i)}function A(e){var t=e.data("error-popup");t&&t.is(":visible")&&t.fadeOutAndRemove(),e.removeClass("validation-error"),e.removeData("error-popup"),e.removeData("error-message")}function I(){var e=!1,t=$("#sidebar, .sidebar").first();if(!t.length)return!1;var n=t.offset().left;return $(".message").each(function(){var t=$(this);return t.offset().left+t.outerWidth()>n?(e=!0,!1):void 0}),e}var M=$("body").hasClass("js-ask-page-v2"),N="Title",P="Body",L="Tags",D="Mentions",R="EditComment",B="Excerpt",U="Email",q="General",F="ArticleType",z=[],V=250;return{"initOnBlur":n,"initOnBlurAndSubmit":i,"showErrorsAfterSubmission":w,"validatePostFields":c,"scrollToErrors":y}}();