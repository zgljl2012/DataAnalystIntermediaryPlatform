$(function() {
    // let's init the plugin, that we called "highlight".
    // We will highlight the words "hello" and "world", 
    // and set the input area to a widht and height of 500 and 250 respectively.
    
});

// the plugin that would do the trick
(function($){
    $.fn.extend({
        highlight: function() {
            // the main class
            var pluginClass = function() {};
            // init the class
            // Bootloader
            pluginClass.prototype.__init = function (element) {
                try {
                    this.element = element;
                } catch (err) {
                    this.error(err);
                }
            };
            // centralized error handler
            pluginClass.prototype.error = function (e) {
                // manage error and exceptions here
                //console.info("error!",e);
            };
            // Centralized routing function
            pluginClass.prototype.execute = function (fn, options) {
                try {
                    options = $.extend({},options);
                    if (typeof(this[fn]) == "function") {
                        var output = this[fn].apply(this, [options]);
                    } else {
                        this.error("undefined_function");
                    }
                } catch (err) {
                    this.error(err);
                }
            };
            // **********************
            // Plugin Class starts here
            // **********************
            // init the component
            pluginClass.prototype.init = function (options) {
                try {
                    // the element's reference ( $("#container") ) is stored into "this.element"
                    var scope                   = this;
                    this.options                = options;

                    // just find the different elements we'll need
                    this.highlighterContainer   = this.element.find('#highlighterContainer');
                    this.inputContainer         = this.element.find('#inputContainer');
                    this.textarea               = this.inputContainer.find('textarea');
                    this.highlighter            = this.highlighterContainer.find('#highlighter');

                    // apply the css
                    this.element.css('position','relative');

                    // place both the highlight container and the textarea container
                    // on the same coordonate to superpose them.
                    this.highlighterContainer.css({
                        'position':         'absolute',
                        'left':             '0',
                        'top':              '0',
                        'border':           '1px dashed #ff0000',
                        'width':            this.options.width,
                        'height':           this.options.height,
                        'cursor':           'text'
                    });
                    this.inputContainer.css({
                        'position':         'absolute',
                        'left':             '0',
                        'top':              '0',
                        'border':           '1px solid #000000'
                    });
                    // now let's make sure the highlit div and the textarea will superpose,
                    // by applying the same font size and stuffs.
                    // the highlighter must have a white text so it will be invisible
                    this.highlighter.css({

                        'padding':          '7px',
                        'color':            '#eeeeee',
                        'background-color': '#ffffff',
                        'margin':           '0px',
                        'font-size':        '11px',
                        'font-family':      '"lucida grande",tahoma,verdana,arial,sans-serif'
                    });
                    // the textarea must have a transparent background so we can see the highlight div behind it
                    this.textarea.css({
                        'background-color': 'transparent',
                        'padding':          '5px',
                        'margin':           '0px',
                        'font-size':        '11px',
                        'width':            this.options.width,
                        'height':           this.options.height,
                        'font-family':      '"lucida grande",tahoma,verdana,arial,sans-serif'
                    });

                    // apply the hooks
                    this.highlighterContainer.bind('click', function() {
                        scope.textarea.focus();
                    });
                    this.textarea.bind('keyup', function() {
                        // when we type in the textarea, 
                        // we want the text to be processed and re-injected into the div behind it.
                        scope.applyText($(this).val());
                    });
                } catch (err) {
                    this.error(err);
                }
                return true;
            };
            pluginClass.prototype.applyText = function (text) {
                try {
                    var scope                   = this;

                    // parse the text:
                    // replace all the line braks by <br/>, and all the double spaces by the html version &nbsp;
                    text = this.replaceAll(text,'\n','<br/>');
                    text = this.replaceAll(text,'  ','&nbsp;&nbsp;');

                    // replace the words by a highlighted version of the words
                    for (var i=0;i<this.options.words.length;i++) {
                        text = this.replaceAll(text,this.options.words[i],'<span style="background-color: #D8DFEA;">'+this.options.words[i]+'</span>');
                    }

                    // re-inject the processed text into the div
                    this.highlighter.html(text);

                } catch (err) {
                    this.error(err);
                }
                return true;
            };
            // "replace all" function
            pluginClass.prototype.replaceAll = function(txt, replace, with_this) {
                return txt.replace(new RegExp(replace, 'g'),with_this);
            }

            // don't worry about this part, it's just the required code for the plugin to hadle the methods and stuffs. Not relevant here.
            //**********************
            // process
            var fn;
            var options;
            if (arguments.length == 0) {
                fn = "init";
                options = {};
            } else if (arguments.length == 1 && typeof(arguments[0]) == 'object') {
                fn = "init";
                options = $.extend({},arguments[0]);
            } else {
                fn = arguments[0];
                options = $.extend({},arguments[1]);
            }

            $.each(this, function(idx, item) {
                // if the component is not yet existing, create it.
                if ($(item).data('highlightPlugin') == null) {
                    $(item).data('highlightPlugin', new pluginClass());
                    $(item).data('highlightPlugin').__init($(item));
                }
                $(item).data('highlightPlugin').execute(fn, options);
            });
            return this;
        }
    });

})(jQuery);



